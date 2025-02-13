package org.chenjh.aiqasystem.exception.custom;

/**
 * @author hjong
 * @date 2025−01−17
 */
public class ServerException extends BaseException{
    public ServerException(String message) {
        super(message);
    }
    public ServerException(String message, Throwable e) {
        super(message, e);
    }
}