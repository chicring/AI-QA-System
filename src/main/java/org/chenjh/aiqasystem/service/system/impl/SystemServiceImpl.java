package org.chenjh.aiqasystem.service.system.impl;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.dto.system.SystemInfoDTO;
import org.chenjh.aiqasystem.repo.question.QuestionRepository;
import org.chenjh.aiqasystem.repo.system.OperationLogRepository;
import org.chenjh.aiqasystem.repo.system.UserRepository;
import org.chenjh.aiqasystem.service.system.SystemService;
import org.springframework.stereotype.Service;

/**
 * @author hjong
 * @date 2025−04−13
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Resource
    private QuestionRepository questionRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private OperationLogRepository operationLogRepository;

    @Override
    public SystemInfoDTO querySystemInfo() {

        Long questionCount = questionRepository.count();

        Long userCount = userRepository.count();

        Long todayLogCount = operationLogRepository.countTodayOperationLog();

        Long totalLogCount = operationLogRepository.countOperationLog();

        return SystemInfoDTO.builder()
                .questionCount(questionCount)
                .userCount(userCount)
                .todayLogCount(todayLogCount)
                .totalLogCount(totalLogCount)
                .build();
    }
}
