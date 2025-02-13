package org.chenjh.aiqasystem.service.question;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.QuestionQueryVO;
import org.chenjh.aiqasystem.domain.vo.QuestionSaveVO;

/**
 * @author hjong
 * @date 2025-01-11
 **/
public interface QuestionService{


    /**
     * 保存问题
     * @param  question
     * @return QuestionDTO
     */
    QuestionDTO saveQuestion(QuestionSaveVO question);

    /**
     * 删除问题
     * @param id
     */
    void deleteQuestion(Long id);

    /**
     * 查询问题
     * @param id
     * @return QuestionDTO
     */
    QuestionDTO getQuestionById(Long id);

    /**
     * 查询问题
     * @param question
     * @return QuestionDTO
     */
    PageResult<QuestionDTO> getQuestionList(QuestionQueryVO question);
}
