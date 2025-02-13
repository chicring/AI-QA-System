package org.chenjh.aiqasystem.repo.question;


import com.nrapendra.jooq.Tables;
import com.nrapendra.jooq.tables.records.TagRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hjong
 * @date 2025-01-09
 **/
@Repository
public class TagRepository {

    private final DSLContext dsl;

    public TagRepository(DSLContext dsl) {
        this.dsl = dsl;
    }


    public List<TagRecord> findByQuestionId(Long questionId) {
        return dsl.select()
                .from(Tables.QA_TAG)
                .leftJoin(Tables.QA_QUESTION_TAG).on(Tables.QA_TAG.TAG_ID.eq(Tables.QA_QUESTION_TAG.TAG_ID))
                .where(Tables.QA_QUESTION_TAG.QUESTION_ID.eq(questionId))
                .fetch()
                .into(TagRecord.class);
    }

}
