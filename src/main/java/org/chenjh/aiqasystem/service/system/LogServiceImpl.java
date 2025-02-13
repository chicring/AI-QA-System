package org.chenjh.aiqasystem.service.system;

import org.chenjh.aiqasystem.domain.entity.system.OperationLog;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author hjong
 * @date 2025−01−16
 */
@Service
public class LogServiceImpl implements LogService{


    @Override
    public void saveOperationLog(String content, String methodName, String requestParams, String operator, long timeTaken) {
        OperationLog log = new OperationLog();
        log.setContent(content);
        log.setMethodName(methodName);
        log.setRequestParams(requestParams);
        log.setOperator(operator);
        log.setOperationTime(LocalDateTime.now());
        log.setTimeTaken(timeTaken);
    }
}
