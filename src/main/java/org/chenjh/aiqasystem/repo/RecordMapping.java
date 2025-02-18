package org.chenjh.aiqasystem.repo;

import org.chenjh.aiqasystem.domain.dto.QuestionDTO;
import org.jooq.Record;
import org.jooq.RecordMapper;

/**
 * @author hjong
 * @date 2025−02−19
 */
public class RecordMapping implements RecordMapper<Record, QuestionDTO> {
    @Override
    public  QuestionDTO map(Record record) {
        return null;
    }
}
