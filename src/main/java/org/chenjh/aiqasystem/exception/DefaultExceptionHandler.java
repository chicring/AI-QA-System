package org.chenjh.aiqasystem.exception;

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

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<?> handleException(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getFieldErrors()
                .stream()
                .map(n -> String.format("%s", n.getDefaultMessage()))
                .reduce((x, y) -> String.format("%s; %s", x, y))
                .orElse("参数输入有误");
        log.error("MethodArgumentNotValidException异常，参数校验异常：{}", msg);
        return Result.failure(ResultCode.BAD_REQUEST, msg);
    }

    @ExceptionHandler({BadRequestException.class})
    public Result<?> handleBadRequestException(BadRequestException e) {
        return Result.failure(ResultCode.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler({NotAllowedException.class})
    public Result<?> handleNotAllowedException(NotAllowedException e) {
        return Result.failure(ResultCode.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public Result<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        return Result.failure(ResultCode.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler({ResourceConflictException.class})
    public Result<?> handleResourceConflictException(ResourceConflictException e) {
        return Result.failure(ResultCode.CONFLICT, e.getMessage());
    }

//    @ExceptionHandler(ExpiredJwtException.class)
//    public ResultJson<?> handleExpiredJwtException(ExpiredJwtException e) {
//        return ResultJson.failure(ResultCode.TOKEN_EXPIRED, e.getMessage());
//    }

    @ExceptionHandler(AccessDeniedException.class)
    public Result<?> handleAccessDeniedException(AccessDeniedException e) {
        return Result.failure(ResultCode.FORBIDDEN, e.getMessage());
    }

    @ExceptionHandler({ServerException.class})
    public Result<?> handleServerException(ServerException e) {
        log.error(e.getMessage());
        return Result.failure(e.getCode(), e.getMessage());
    }

}
