package org.chenjh.aiqasystem.repo.question;


import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.question.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.question.QueryQuestionVO;
import org.chenjh.aiqasystem.domain.vo.question.SaveQuestionVO;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.nrapendra.jooq.Tables.QA_QUESTION;
import static com.nrapendra.jooq.Tables.QA_TAG;
import static com.nrapendra.jooq.tables.MappingTb.QA_MAPPING;
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

    /**
     * 查询所有问题数量
     * @return 问题列表
     */
    public Long count() {
        return dsl.selectCount()
                .from(QA_QUESTION)
                .where(QA_QUESTION.IS_DELETED.eq(false))
                .fetchOne(0, Long.class);
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

    /**
     * 逻辑删除问题
     * @param id 问题
     * @return 是否更新成功
     */
    public boolean deleteById(Long id) {
        return dsl.update(QA_QUESTION)
                .set(QA_QUESTION.IS_DELETED, true)
                .where(QA_QUESTION.QUESTION_ID.eq(id))
                .execute() > 0;
    }


    public Optional<QuestionDTO> findById(Long id) {

        return dsl.select(
                    QA_QUESTION.QUESTION_ID,
                    QA_QUESTION.QUESTION_TITLE,
                    QA_QUESTION.QUESTION_TIPS,
                    QA_QUESTION.DIFFICULTY,
                    QA_QUESTION.CREATE_TIME,
                    QA_QUESTION.VIEW_COUNT,
                    QA_MAPPING.CATEGORY_ID,
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
                .join(QA_MAPPING)
                .on(QA_QUESTION.QUESTION_ID.eq(QA_MAPPING.QUESTION_ID))
                .where(QA_QUESTION.QUESTION_ID.eq(id))
                .and(QA_QUESTION.IS_DELETED.eq(false))
                .fetchOptionalInto(QuestionDTO.class);
    }


    public void updateViewCount(Long id) {
        dsl.update(QA_QUESTION)
                .set(QA_QUESTION.VIEW_COUNT, QA_QUESTION.VIEW_COUNT.add(1))
                .where(QA_QUESTION.QUESTION_ID.eq(id))
                .execute();
    }


    public List<QuestionDTO> searchByTitle(String q) {
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
                .join(QA_MAPPING)
                .on(QA_QUESTION.QUESTION_ID.eq(QA_MAPPING.QUESTION_ID))
                .join(QA_TAG)
                .on(QA_TAG.ID.eq(QA_MAPPING.TAG_ID))
                .where(QA_QUESTION.QUESTION_TITLE.like(concat("%", q, "%")))
                .and(QA_QUESTION.IS_DELETED.eq(false))
                .groupBy(QA_QUESTION.QUESTION_ID,  // 添加 groupBy 确保每个问题只出现一次
                        QA_QUESTION.QUESTION_TITLE,
                        QA_QUESTION.QUESTION_TIPS,
                        QA_QUESTION.DIFFICULTY,
                        QA_QUESTION.CREATE_TIME,
                        QA_QUESTION.VIEW_COUNT)
                .fetchInto(QuestionDTO.class);
    }

    public PageResult<QuestionDTO> findPageResult(QueryQuestionVO vo){
        Condition condition = buildCondition(vo);

        Long total = dsl.selectCount()
                .from(QA_QUESTION)
                .join(QA_MAPPING)
                .on(QA_QUESTION.QUESTION_ID.eq(QA_MAPPING.QUESTION_ID))
                .where(condition).fetchOne(0, Long.class);


        List<QuestionDTO> list = dsl.select(
                    QA_QUESTION.QUESTION_ID,
                    QA_QUESTION.QUESTION_TITLE,
                    QA_QUESTION.QUESTION_TIPS,
                    QA_QUESTION.DIFFICULTY,
                    QA_QUESTION.CREATE_TIME,
                    QA_QUESTION.VIEW_COUNT,
                    QA_MAPPING.CATEGORY_ID,
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
                .join(QA_MAPPING)
                .on(QA_QUESTION.QUESTION_ID.eq(QA_MAPPING.QUESTION_ID))
                .where(condition)
                .groupBy(QA_QUESTION.QUESTION_ID,  // 添加 groupBy 确保每个问题只出现一次
                        QA_QUESTION.QUESTION_TITLE,
                        QA_QUESTION.QUESTION_TIPS,
                        QA_QUESTION.DIFFICULTY,
                        QA_QUESTION.CREATE_TIME,
                        QA_QUESTION.VIEW_COUNT,
                        QA_MAPPING.CATEGORY_ID)
                .limit(vo.getPageSize())
                .offset((vo.getPageNum() - 1) * vo.getPageSize())
                .fetchInto(QuestionDTO.class);

        return new PageResult<>(vo.getPageNum(), vo.getPageSize(), total, list);
    }

    // 构建查询条件
    private Condition buildCondition(QueryQuestionVO vo) {
        Condition condition = DSL.trueCondition();
        condition = condition.and(QA_QUESTION.IS_DELETED.eq(false));

        if(vo.getCategoryId() != null){
            condition = condition.and(QA_MAPPING.CATEGORY_ID.eq(vo.getCategoryId()));
        }

        if(vo.getTitle() != null && !vo.getTitle().isEmpty()){
            condition = condition.and(QA_QUESTION.QUESTION_TITLE.like(concat("%", vo.getTitle(), "%")));
        }

        if(vo.getDifficulty() != null){
            condition = condition.and(QA_QUESTION.DIFFICULTY.eq(UInteger.valueOf(vo.getDifficulty())));
        }

        if(vo.getTagNames() != null && !vo.getTagNames().isEmpty()){
            condition = condition.and(QA_MAPPING.TAG_ID.in(
                    select(QA_TAG.ID)
                            .from(QA_TAG)
                            .where(QA_TAG.TAG_NAME.in(vo.getTagNames()))
            ));
        }
        return condition;
    }
}
