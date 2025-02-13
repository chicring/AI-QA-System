package org.chenjh.aiqasystem.exception;

import lombok.extern.slf4j.Slf4j;
import org.chenjh.aiqasystem.domain.ResultCode;
import org.chenjh.aiqasystem.domain.ResultJson;
import org.chenjh.aiqasystem.exception.custom.*;
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
    @ExceptionHandler({BadRequestException.class})
    public ResultJson<?> handleBadRequestException(BadRequestException e) {
        return ResultJson.failure(ResultCode.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler({NotAllowedException.class})
    public ResultJson<?> handleNotAllowedException(NotAllowedException e) {
        return ResultJson.failure(ResultCode.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResultJson<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        return ResultJson.failure(ResultCode.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler({ResourceConflictException.class})
    public ResultJson<?> handleResourceConflictException(ResourceConflictException e) {
        return ResultJson.failure(ResultCode.CONFLICT, e.getMessage());
    }

//    @ExceptionHandler(ExpiredJwtException.class)
//    public ResultJson<?> handleExpiredJwtException(ExpiredJwtException e) {
//        return ResultJson.failure(ResultCode.TOKEN_EXPIRED, e.getMessage());
//    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResultJson<?> handleAccessDeniedException(AccessDeniedException e) {
        return ResultJson.failure(ResultCode.FORBIDDEN, e.getMessage());
    }

    @ExceptionHandler({ServerException.class})
    public ResultJson<?> handleServerException(Exception e) {
        log.error(e.getMessage());
        return ResultJson.failure(ResultCode.SERVER_ERROR, e.getMessage());
    }

}
