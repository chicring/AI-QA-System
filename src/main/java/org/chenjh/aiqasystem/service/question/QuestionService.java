package org.chenjh.aiqasystem.service.question;

import com.nrapendra.jooq.tables.records.QuestionRecord;
import org.chenjh.aiqasystem.domain.dto.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.QuestionVO;

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
    QuestionDTO saveQuestion(QuestionVO question);

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
}
