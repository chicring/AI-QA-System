package org.chenjh.aiqasystem.repo.question;

import com.nrapendra.jooq.tables.records.MappingRecord;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 * @author hjong
 * @date 2025−02−13
 */
@Repository
public class QAMappingRepository {
    private final DSLContext dsl;

    public QAMappingRepository(DSLContext dsl) {
        this.dsl = dsl;
    }


    public Boolean save(Long questionId, Long categoryId, List<Long> tagId){

        List<MappingRecord> records = tagId.stream().map(a -> {
            MappingRecord record = new MappingRecord();
            record.setQuestionId(questionId);
            record.setCategoryId(categoryId);
            record.setTagId(a);

            return record;
        }).toList();

        return dsl.batchInsert(records).execute().length == records.size();
    }
}
