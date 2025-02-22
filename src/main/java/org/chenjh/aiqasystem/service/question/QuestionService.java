package org.chenjh.aiqasystem.service.question;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.question.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.question.QueryQuestionVO;
import org.chenjh.aiqasystem.domain.vo.question.SaveQuestionVO;

/**
 * @author hjong
 * @date 2025-01-11
 **/
public interface QuestionService{


    /**
     * 保存问题
     * @param  question 问题
     */
    void saveQuestion(SaveQuestionVO question);

    /**
     * 删除问题
     * @param id 问题id
     */
    void deleteQuestion(Long id);

    /**
     * 查询问题
     * @param id 问题id
     * @return QuestionDTO
     */
    QuestionDTO getQuestionById(Long id);

    /**
     * 查询问题
     * @param question 问题查询条件
     * @return QuestionDTO
     */
    PageResult<QuestionDTO> getQuestionList(QueryQuestionVO question);
}
