package org.chenjh.aiqasystem.services.question;

import com.mybatisflex.core.paginate.Page;
import org.chenjh.aiqasystem.domain.dto.question.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.question.QueryQuestionVO;
import org.chenjh.aiqasystem.domain.vo.question.QuestionVO;

/**
 * @author hjong
 * @date 2025-04-17
 **/
public interface QuestionService {

    /**
     * 保存或者更新问题
     * @param question 问题
     */
    void savOrUpdateQuestion(QuestionVO question);

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
    Page<QuestionDTO> queryQuestionPage(QueryQuestionVO question);
}
