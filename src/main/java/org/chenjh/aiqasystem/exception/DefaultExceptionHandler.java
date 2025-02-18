package org.chenjh.aiqasystem.exception;

import cn.dev33.satoken.exception.NotLoginException;
import lombok.extern.slf4j.Slf4j;
import org.chenjh.aiqasystem.domain.ResultCode;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.exception.custom.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

/**
 * 异常处理类
 *
 */
@RestControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

    /**
     * 处理未登录异常
     */
    @ExceptionHandler(NotLoginException.class)
    public Result<?> handleNotLoginException(NotLoginException nle) {
        // 判断场景值，定制化异常信息
        String message = "";
        if(nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未能读取到有效 token";
        }
        else if(nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token 无效";
        }
        else if(nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token 已过期";
        }
        else if(nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token 已被顶下线";
        }
        else if(nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token 已被踢下线";
        }
        else if(nle.getType().equals(NotLoginException.TOKEN_FREEZE)) {
            message = "token 已被冻结";
        }
        else if(nle.getType().equals(NotLoginException.NO_PREFIX)) {
            message = "未按照指定前缀提交 token";
        }
        return Result.failure(ResultCode.UNAUTHORIZED.getCode(), message);
    }

    /**
     * 处理参数校验异常
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<?> handleException(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getFieldErrors()
                .stream()
                .map(n -> String.format("%s", n.getDefaultMessage()))
                .reduce((x, y) -> String.format("%s; %s", x, y))
                .orElse("参数输入有误");
        log.error("MethodArgumentNotValidException异常，参数校验异常：{}", msg);
        return Result.failure(ResultCode.BAD_REQUEST.getCode(), msg);
    }

    /**
     * 处理参数校验异常
     */
    @ExceptionHandler({BadRequestException.class})
    public Result<?> handleBadRequestException(BadRequestException e) {
        return Result.failure(ResultCode.BAD_REQUEST.getCode(), e.getMessage());
    }

    /**
     * 权限校验异常
     */
    @ExceptionHandler({NotAllowedException.class})
    public Result<?> handleNotAllowedException(NotAllowedException e) {
        return Result.failure(ResultCode.BAD_REQUEST.getCode(), e.getMessage());
    }

    /**
     * 处理资源不存在异常
     */
    @ExceptionHandler({ResourceNotFoundException.class})
    public Result<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        return Result.failure(ResultCode.NOT_FOUND.getCode(), e.getMessage());
    }

    /**
     * 处理资源冲突异常
     */
    @ExceptionHandler({ResourceConflictException.class})
    public Result<?> handleResourceConflictException(ResourceConflictException e) {
        return Result.failure(ResultCode.CONFLICT.getCode(), e.getMessage());
    }


    /**
     * 处理权限不足异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Result<?> handleAccessDeniedException(AccessDeniedException e) {
        return Result.failure(ResultCode.FORBIDDEN.getCode(), e.getMessage());
    }

    /**
     * 处理服务器异常
     */
    @ExceptionHandler({ServerException.class})
    public Result<?> handleServerException(ServerException e) {
        log.error(e.getMessage());
        return Result.failure(ResultCode.SERVER_ERROR.getCode(), e.getMessage());
    }

}
