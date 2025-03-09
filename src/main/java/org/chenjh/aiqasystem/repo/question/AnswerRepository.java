package org.chenjh.aiqasystem.repo.question;

import com.nrapendra.jooq.tables.records.AnswerRecord;
import org.chenjh.aiqasystem.domain.dto.question.AnswerDTO;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.nrapendra.jooq.tables.AnswerTb.QA_ANSWER;


/**
 * @author hjong
 * @date 2025−02−22
 */
@Repository
public class AnswerRepository {
    private final DSLContext dsl;

    public AnswerRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    /**
     * Save the answer to the question
     * @param questionId 题目id
     * @param answer 答案
     * @return boolean
     */
    public Boolean save(Long questionId, String answer){

        AnswerRecord record = new AnswerRecord();
        record.setQuestionId(questionId);
        record.setQuestionAnswer(answer);

        return dsl.insertInto(QA_ANSWER)
                .set(record)
                .execute() > 0;
    }


    public AnswerDTO findAnswerByQuestionId(Long questionId){

        List<String> answers = dsl.select(QA_ANSWER.QUESTION_ANSWER)
                .from(QA_ANSWER)
                .where(QA_ANSWER.QUESTION_ID.eq(questionId))
                .fetch()
                .getValues(QA_ANSWER.QUESTION_ANSWER);

        return new AnswerDTO(questionId, answers);
    }

    /**
     * Update the answer to the question
     * @param answerId 答案id
     * @return boolean
     */
    public Boolean delete(Long answerId){
        return dsl.deleteFrom(QA_ANSWER)
                .where(QA_ANSWER.ID.eq(answerId))
                .execute() > 0;
    }
}
