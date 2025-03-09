package org.chenjh.aiqasystem.service.question;

import org.chenjh.aiqasystem.domain.dto.question.AnswerDTO;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−22
 */
public interface AnswerService {

    /**
     * 根据问题id查找答案
     * @param questionId question id
     * @return 答案
     */
    AnswerDTO findAnswerByQuestionId(Long questionId);

    /**
     * 保存答案
     * @param questionId question id
     * @param answer answer
     */
    void saveAnswer(Long questionId, String answer);

    /**
     * 删除答案
     * @param answerId answer id
     */
    void deleteAnswer(Long answerId);
}
