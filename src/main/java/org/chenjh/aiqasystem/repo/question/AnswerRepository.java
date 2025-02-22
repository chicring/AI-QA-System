package org.chenjh.aiqasystem.repo.question;

import com.nrapendra.jooq.tables.records.AnswerRecord;
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
    public Boolean save(Long questionId, List<String> answer){

        List<AnswerRecord> records = answer.stream().map(a -> {
            AnswerRecord record = new AnswerRecord();
            record.setQuestionId(questionId);
            record.setQuestionAnswer(a);
            return record;
        }).toList();

        return dsl.batchInsert(records).execute().length == records.size();
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
