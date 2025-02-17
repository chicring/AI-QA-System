package org.chenjh.aiqasystem.repo.question;

import com.nrapendra.jooq.Tables;
import com.nrapendra.jooq.tables.records.QuestionTagRecord;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep2;
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
     * @param questionId 问题id
     * @param tagIds 标签id数组
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

    /**
     * 删除问题标签
     * @param questionId 问题id
     * @param tagId 标签id
     * @return boolean
     */
    public boolean deleteById(long questionId, long tagId) {
        return dsl.delete(Tables.QA_QUESTION_TAG)
                .where(Tables.QA_QUESTION_TAG.QUESTION_ID.eq(questionId))
                .and(Tables.QA_QUESTION_TAG.TAG_ID.eq(tagId))
                .execute() == 1;
    }


    /**
     * 删除问题标签
     * @param questionId 问题id
     * @return boolean
     */
    public boolean deleteByQuestionId(long questionId) {
        return dsl.delete(Tables.QA_QUESTION_TAG)
                .where(Tables.QA_QUESTION_TAG.QUESTION_ID.eq(questionId))
                .execute() > 0;
    }


    /**
     * 删除标签
     * @param tagId 标签ID
     * @return boolean
     */
    public boolean deleteByTagId(long tagId) {
        return dsl.delete(Tables.QA_QUESTION_TAG)
                .where(Tables.QA_QUESTION_TAG.TAG_ID.eq(tagId))
                .execute() > 0;
    }
}
