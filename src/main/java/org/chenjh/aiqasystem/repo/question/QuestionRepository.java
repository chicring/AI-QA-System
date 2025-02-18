package org.chenjh.aiqasystem.repo.question;


import com.nrapendra.jooq.Tables;
import com.nrapendra.jooq.tables.records.QuestionRecord;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.QuestionDTO;
import org.chenjh.aiqasystem.domain.dto.TagDTO;
import org.chenjh.aiqasystem.domain.vo.question.QuestionQueryVO;
import org.chenjh.aiqasystem.repo.RecordMapping;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UByte;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.nrapendra.jooq.Tables.QA_QUESTION;
import static com.nrapendra.jooq.tables.QuestionTagTb.QA_QUESTION_TAG;
import static com.nrapendra.jooq.tables.TagTb.QA_TAG;
import static org.chenjh.aiqasystem.common.CommonUtil.generateId;
import static org.jooq.impl.DSL.*;

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
    public QuestionRecord save(QuestionRecord tablePojo) {
        tablePojo.setQuestionId(generateId());
        QuestionRecord questionRecord = dsl.newRecord(QA_QUESTION,tablePojo);
        questionRecord.store();


        return questionRecord;
    }

    public QuestionRecord update(QuestionRecord tablePojo, int id) {
        return null;
    }

    public List<QuestionRecord> findAll() {
        return dsl.selectFrom(QA_QUESTION).fetchInto(QuestionRecord.class);
    }


    public Optional<QuestionRecord> findById(long id) {

        return dsl.selectFrom(QA_QUESTION)
                .where(QA_QUESTION.QUESTION_ID.eq(id))
                .fetchOptional();
    }


    public boolean deleteById(long id) {
        return dsl.delete(QA_QUESTION)
                .where(QA_QUESTION.QUESTION_ID.eq(id))
                .execute() == 1;
    }

    public PageResult<QuestionDTO> getQuestionList(QuestionQueryVO question) {
        int pageNum = question.getPageNum() != null ? question.getPageNum() : 1;
        int pageSize = question.getPageSize() != null ? question.getPageSize() : 10;
        int offset = (pageNum - 1) * pageSize;

        List<QuestionDTO> questionList = dsl
                .select(
                        QA_QUESTION.QUESTION_ID,
                        QA_QUESTION.QUESTION_TITLE,
                        QA_QUESTION.QUESTION_SOLUTION,
                        QA_QUESTION.DIFFICULTY,
                        QA_QUESTION.VIEW_COUNT,
                        QA_QUESTION.CREATOR,
                        QA_QUESTION.CREATOR_USER_ID,
                        multiset(
                                select(
                                        QA_TAG.TAG_ID,
                                        QA_TAG.TAG_NAME,
                                        QA_TAG.TAG_SORT,
                                        QA_TAG.PARENT_TAG_ID
                                ).from(QA_TAG).join(QA_QUESTION_TAG)
                                .on(Tables.QA_TAG.TAG_ID.eq(QA_QUESTION_TAG.TAG_ID))
                                .where( (question.getTagIds() == null || question.getTagIds().isEmpty()) ?
                                        DSL.noCondition() :
                                        QA_QUESTION_TAG.QUESTION_ID.eq(QA_QUESTION.QUESTION_ID)
                                )
                                .orderBy(QA_TAG.TAG_SORT.asc())
                        ).convertFrom(
                                rs -> rs.map(
                                        r -> new TagDTO(r.get(QA_TAG.TAG_ID), r.get(QA_TAG.TAG_NAME),
                                                r.get(QA_TAG.TAG_SORT).intValue(),r.get(QA_TAG.PARENT_TAG_ID).intValue()
                               ))
                        ).as("tags")
                )
                .from(QA_QUESTION)
                .join(Tables.QA_QUESTION_TAG)
                .on(QA_QUESTION.QUESTION_ID.eq(Tables.QA_QUESTION_TAG.QUESTION_ID))
                .where( (question.getTitle()== null || question.getTitle().isEmpty()) ?
                        DSL.noCondition() :
                        QA_QUESTION.QUESTION_TITLE.like(question.getTitle())
                )
                .and( (question.getDifficulty() == null) ?
                        DSL.noCondition() :
                        QA_QUESTION.DIFFICULTY.eq(UByte.valueOf(question.getDifficulty()))
                )
                .and( (question.getTagIds() == null || question.getTagIds().isEmpty()) ?
                        DSL.noCondition() :
                        Tables.QA_QUESTION_TAG.TAG_ID.in(question.getTagIds())
                )
                .limit(pageSize)
                .offset(offset)
                .fetch(r -> {
                    QuestionDTO questionDTO = new QuestionDTO();
                    questionDTO.setId(r.get(QA_QUESTION.QUESTION_ID));
                    questionDTO.setTitle(r.get(QA_QUESTION.QUESTION_TITLE));
                    questionDTO.setSolution(r.get(QA_QUESTION.QUESTION_SOLUTION));
                    questionDTO.setDifficultyLevel(r.get(QA_QUESTION.DIFFICULTY).intValue());
                    questionDTO.setViewCount(r.get(QA_QUESTION.VIEW_COUNT).intValue());
                    questionDTO.setCreator(r.get(QA_QUESTION.CREATOR));
                    questionDTO.setCreatorId(r.get(QA_QUESTION.CREATOR_USER_ID));
                    questionDTO.setTags((List<TagDTO>) r.get("tags"));
                    return questionDTO;
                });

        Long total = dsl
                .selectCount()
                .from(QA_QUESTION)
                .join(Tables.QA_QUESTION_TAG)
                .on(QA_QUESTION.QUESTION_ID.eq(Tables.QA_QUESTION_TAG.QUESTION_ID))
                .where( (question.getTitle()== null || question.getTitle().isEmpty()) ?
                        DSL.noCondition() :
                        QA_QUESTION.QUESTION_TITLE.like(concat("%" + question.getTitle() + "%"))
                )
                .and( (question.getDifficulty() == null) ?
                        DSL.noCondition() :
                        QA_QUESTION.DIFFICULTY.eq(UByte.valueOf(question.getDifficulty()))
                )
                .and( (question.getTagIds() == null || question.getTagIds().isEmpty()) ?
                        DSL.noCondition() :
                        Tables.QA_QUESTION_TAG.TAG_ID.in(question.getTagIds())
                )
                .stream().count();

        return PageResult.<QuestionDTO>builder()
                .page(pageNum)
                .rows(pageSize)
                .total(total)
                .data(questionList)
                .build();
    }
}
