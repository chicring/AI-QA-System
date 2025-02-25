package org.chenjh.aiqasystem.service.system;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.system.OperationLogDTO;
import org.chenjh.aiqasystem.domain.entity.system.OperationLog;
import org.chenjh.aiqasystem.repo.system.OperationLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author hjong
 * @date 2025−01−16
 */
@Service
public class LogServiceImpl implements LogService{

    @Resource
    private OperationLogRepository operationLogRepository;

    @Override
    public void saveOperationLog(String content, String methodName, String requestParams, String operator, long timeTaken) {
        operationLogRepository.save(content, methodName, requestParams, operator, timeTaken);
    }

    @Override
    public PageResult<OperationLogDTO> queryOperationLog(String q, int page, int pageSize) {
        return null;
    }
}
