package org.chenjh.aiqasystem.repo.question;


import com.nrapendra.jooq.Tables;
import com.nrapendra.jooq.tables.records.QuestionRecord;
import org.chenjh.aiqasystem.repo.JOOQRepository;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author hjong
 * @date 2025-01-09
 **/
@Repository
public class QuestionRepository implements JOOQRepository<QuestionRecord> {

    private final DSLContext dsl;

    public QuestionRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public QuestionRecord save(QuestionRecord tablePojo) {
        return dsl.newRecord(Tables.QA_QUESTION,tablePojo);
    }

    @Override
    public QuestionRecord update(QuestionRecord tablePojo, int id) {
        return null;
    }

    @Override
    public List<QuestionRecord> findAll() {
        return dsl.selectFrom(Tables.QA_QUESTION).fetchInto(QuestionRecord.class);
    }

    @Override
    public Optional<QuestionRecord> findById(long id) {
        return dsl.selectFrom(Tables.QA_QUESTION)
                .where(Tables.QA_QUESTION.QUESTION_ID.eq(id))
                .fetchOptional();
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
