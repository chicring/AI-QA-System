package org.chenjh.aiqasystem.service.question.impl;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.dto.question.AnswerDTO;
import org.chenjh.aiqasystem.repo.question.AnswerRepository;
import org.chenjh.aiqasystem.service.question.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−22
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    @Resource
    private AnswerRepository answerRepository;

    @Override
    public AnswerDTO findAnswerByQuestionId(Long questionId) {
        return answerRepository.findAnswerByQuestionId(questionId);
    }

    @Override
    public void saveAnswer(Long questionId, String answer) {
        answerRepository.save(questionId, answer);
    }


    @Override
    public void deleteAnswer(Long answerId) {
        answerRepository.delete(answerId);
    }


}
