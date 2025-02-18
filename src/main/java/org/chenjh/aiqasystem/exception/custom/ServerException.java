package org.chenjh.aiqasystem.exception.custom;

import lombok.Getter;
import lombok.Setter;
import org.chenjh.aiqasystem.domain.ResultCode;

/**
 * @author hjong
 * @date 2025−01−17
 */
@Setter
@Getter
public class ServerException extends BaseException{

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, Throwable e) {
        super(message, e);
    }

}