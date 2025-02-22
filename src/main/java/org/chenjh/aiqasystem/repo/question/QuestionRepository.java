package org.chenjh.aiqasystem.repo.question;


import org.chenjh.aiqasystem.domain.dto.question.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.question.SaveQuestionVO;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.nrapendra.jooq.Tables.QA_QUESTION;
import static com.nrapendra.jooq.Tables.QA_TAG;
import static com.nrapendra.jooq.tables.MappingTb.QA_MAPPING;
import static org.chenjh.aiqasystem.common.CommonUtil.generateId;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;

/**
 * @author hjong
 * @date 2025-01-09
 **/
@Repository
public class QuestionRepository{

    private final DSLContext dsl;

    public QuestionRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    //// 插入并返回插入后的数据
    public Long save(SaveQuestionVO vo) {
        return dsl.insertInto(QA_QUESTION)
                .set(QA_QUESTION.QUESTION_ID, generateId())
                .set(QA_QUESTION.QUESTION_TITLE, vo.getQuestionTitle())
                .set(QA_QUESTION.QUESTION_TIPS, vo.getQuestionTips())
                .set(QA_QUESTION.DIFFICULTY, UInteger.valueOf(vo.getDifficulty()))
                .returning(QA_QUESTION.QUESTION_ID)
                .fetchOne()
                .getQuestionId();
    }


    public Optional<QuestionDTO> findById(Long id) {

        return dsl.select(
                    QA_QUESTION.QUESTION_ID,
                    QA_QUESTION.QUESTION_TITLE,
                    QA_QUESTION.QUESTION_TIPS,
                    QA_QUESTION.DIFFICULTY,
                    QA_QUESTION.CREATE_TIME,
                    QA_QUESTION.VIEW_COUNT,
                    multiset(
                            select(QA_TAG.TAG_NAME)
                                    .from(QA_TAG)
                                    .join(QA_MAPPING)
                                    .on(QA_TAG.ID.eq(QA_MAPPING.TAG_ID))
                                    .where(QA_MAPPING.QUESTION_ID.eq(QA_QUESTION.QUESTION_ID))
                                    .orderBy(QA_TAG.SORT_NUM)
                    ).convertFrom(rs -> rs.map(Record1::value1))
                            .as("tagNames")
                )
                .from(QA_QUESTION)
                .where(QA_QUESTION.QUESTION_ID.eq(id))
                .fetchOptionalInto(QuestionDTO.class);
    }

}
