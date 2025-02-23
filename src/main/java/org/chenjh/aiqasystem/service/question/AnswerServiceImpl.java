package org.chenjh.aiqasystem.service.question;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.repo.question.AnswerRepository;
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
    public void saveAnswer(Long questionId, String answer) {
        saveAnswer(questionId, List.of(answer));
    }

    @Override
    public void saveAnswer(Long questionId, List<String> answer) {
        answerRepository.save(questionId, answer);
    }

    @Override
    public void deleteAnswer(Long answerId) {
        answerRepository.delete(answerId);
    }
}
