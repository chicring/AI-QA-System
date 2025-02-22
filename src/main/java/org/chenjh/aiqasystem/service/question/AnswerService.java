package org.chenjh.aiqasystem.service.question;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−22
 */
public interface AnswerService {

    /**
     * 保存答案
     * @param questionId question id
     * @param answer answer
     */
    void saveAnswer(Long questionId, String answer);

    /**
     * 保存答案
     * @param questionId question id
     * @param answers answers
     */
    void saveAnswer(Long questionId, List<String> answers);

    /**
     * 删除答案
     * @param answerId answer id
     */
    void deleteAnswer(Long answerId);
}
