package org.chenjh.aiqasystem.repo.question;

import com.nrapendra.jooq.Tables;
import com.nrapendra.jooq.tables.records.QuestionTagRecord;
import org.jooq.DSLContext;
import org.jooq.InsertQuery;
import org.jooq.InsertValuesStep2;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import static com.nrapendra.jooq.tables.QuestionTagTb.QA_QUESTION_TAG;

/**
 * @author hjong
 * @date 2025−02−13
 */
@Repository
public class TagQuestionRepository {
    private final DSLContext dsl;

    public TagQuestionRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void save(Long questionId, Long tagId) {
        dsl.insertInto(Tables.QA_QUESTION_TAG)
                .set(QA_QUESTION_TAG.QUESTION_ID, questionId)
                .set(QA_QUESTION_TAG.TAG_ID, tagId)
                .execute();
    }

    /**
     * 批量保存
     * @param questionId
     * @param tagIds
     * @return boolean
     */
    public boolean batchSave(Long questionId, Long[] tagIds) {
        InsertValuesStep2<QuestionTagRecord, Long, Long> step =
                dsl.insertInto(Tables.QA_QUESTION_TAG)
                        .columns(QA_QUESTION_TAG.QUESTION_ID, QA_QUESTION_TAG.TAG_ID);

        for (Long tagId : tagIds) {
            step.values(questionId, tagId);
        }
        return step.execute() > 0;
    }
}
