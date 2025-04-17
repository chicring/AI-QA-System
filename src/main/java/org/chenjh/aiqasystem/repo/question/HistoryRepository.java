package org.chenjh.aiqasystem.repo.question;

import com.nrapendra.jooq.Tables;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.question.HeatmapDTO;
import org.chenjh.aiqasystem.domain.dto.question.QuestionHistoryDTO;
import org.chenjh.aiqasystem.domain.vo.question.QueryHistoryVO;
import org.chenjh.aiqasystem.domain.vo.question.QueryQuestionVO;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.nrapendra.jooq.Tables.QA_QUESTION;
import static com.nrapendra.jooq.Tables.QA_TAG;
import static com.nrapendra.jooq.tables.MappingTb.QA_MAPPING;
import static org.jooq.impl.DSL.*;

/**
 * @author hjong
 * @date 2025−03−07
 */
@Repository
public class HistoryRepository {

    private final DSLContext dsl;

    public HistoryRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    /**
     * 保存或更新浏览次数
     * @param questionId 问题id
     * @param username 用户名
     */
    public void saveOrUpdateView(Long questionId, String username) {
        boolean exist = dsl.fetchExists(Tables.QA_QUESTION_HISTORY, Tables.QA_QUESTION_HISTORY.QUESTION_ID.eq(questionId)
                .and(Tables.QA_QUESTION_HISTORY.USERNAME.eq(username)));
        if (exist) {
            dsl.update(Tables.QA_QUESTION_HISTORY)
                    .set(Tables.QA_QUESTION_HISTORY.VIEW_COUNT, Tables.QA_QUESTION_HISTORY.VIEW_COUNT.add(1))
                    .where(Tables.QA_QUESTION_HISTORY.QUESTION_ID.eq(questionId))
                    .and(Tables.QA_QUESTION_HISTORY.USERNAME.eq(username))
                    .execute();
        } else {
            dsl.insertInto(Tables.QA_QUESTION_HISTORY)
                    .set(Tables.QA_QUESTION_HISTORY.QUESTION_ID, questionId)
                    .set(Tables.QA_QUESTION_HISTORY.USERNAME, username)
                    .execute();
        }
    }

    public void update(Long questionId, String username, Integer status) {
        dsl.update(Tables.QA_QUESTION_HISTORY)
                .set(Tables.QA_QUESTION_HISTORY.STATUS, status)
                .where(Tables.QA_QUESTION_HISTORY.QUESTION_ID.eq(questionId))
                .and(Tables.QA_QUESTION_HISTORY.USERNAME.eq(username))
                .execute();
    }

    public Boolean delete(Long questionId, String username) {
        return dsl.delete(Tables.QA_QUESTION_HISTORY)
                .where(Tables.QA_QUESTION_HISTORY.QUESTION_ID.eq(questionId))
                .and(Tables.QA_QUESTION_HISTORY.USERNAME.eq(username))
                .execute() > 0;
    }

    /**
     * 查询热力图数据 今年每一天的历史数据
     * @return List<HeatmapDTO>
     */
    public List<HeatmapDTO> queryHeatmap(String username) {
        LocalDate startOfYear = LocalDate.now().withDayOfYear(1);
        LocalDate startOfNextYear = startOfYear.plusYears(1);

        return dsl.select(
                        Tables.QA_QUESTION_HISTORY.CREATE_TIME.as("date"),
                        DSL.count().as("count")
                )
                .from(Tables.QA_QUESTION_HISTORY)
                .where(Tables.QA_QUESTION_HISTORY.USERNAME.eq(username))
                .and(Tables.QA_QUESTION_HISTORY.CREATE_TIME.between(
                        startOfYear.atStartOfDay(),
                        startOfNextYear.atStartOfDay()
                ))
                .groupBy(Tables.QA_QUESTION_HISTORY.CREATE_TIME,
                        Tables.QA_QUESTION_HISTORY.USERNAME)
                .orderBy(Tables.QA_QUESTION_HISTORY.CREATE_TIME)
                .fetchInto(HeatmapDTO.class);
    }

    public PageResult<QuestionHistoryDTO> getQuestionHistoryList(QueryHistoryVO vo, String username) {
        Condition condition = buildCondition(vo, username);

        Long total = dsl.selectCount()
                .from(Tables.QA_QUESTION_HISTORY)
                .join(Tables.QA_QUESTION)
                .on(Tables.QA_QUESTION_HISTORY.QUESTION_ID.eq(QA_QUESTION.QUESTION_ID))
                .where(condition)
                .fetchOne(0, Long.class);

        List<QuestionHistoryDTO> list = dsl.select(
                Tables.QA_QUESTION.QUESTION_ID,
                Tables.QA_QUESTION.QUESTION_TITLE,
                Tables.QA_QUESTION.DIFFICULTY,
                Tables.QA_QUESTION_HISTORY.STATUS,
                Tables.QA_QUESTION_HISTORY.VIEW_COUNT,
                Tables.QA_QUESTION_HISTORY.LAST_VIEW_TIME,
                Tables.QA_QUESTION_HISTORY.CREATE_TIME,
                Tables.QA_MAPPING.CATEGORY_ID,
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
                .from(Tables.QA_QUESTION_HISTORY)
                .join(Tables.QA_QUESTION)
                .on(Tables.QA_QUESTION_HISTORY.QUESTION_ID.eq(QA_QUESTION.QUESTION_ID))
                .join(Tables.QA_MAPPING)
                .on(Tables.QA_QUESTION.QUESTION_ID.eq(QA_MAPPING.QUESTION_ID))
                .where(condition)
                .orderBy(Tables.QA_QUESTION_HISTORY.CREATE_TIME.desc())
                .limit(vo.getPageSize())
                .offset((vo.getPageNum() - 1) * vo.getPageSize())
                .fetchInto(QuestionHistoryDTO.class);

        return new PageResult<>(vo.getPageNum(), vo.getPageSize(), total, list);
    }

    // 构建查询条件
    private Condition buildCondition(QueryHistoryVO vo, String username){
        Condition condition = Tables.QA_QUESTION_HISTORY.USERNAME.eq(username);
        if (vo.getStatus() != null) {
            condition = condition.and(Tables.QA_QUESTION_HISTORY.STATUS.eq(vo.getStatus()));
        }
        if (vo.getQ() != null && !vo.getQ().isEmpty()) {
            condition = condition.and(Tables.QA_QUESTION.QUESTION_TITLE.like(concat("%", vo.getQ(), "%")));
        }
        if (vo.getDifficulty() != null) {
            condition = condition.and(Tables.QA_QUESTION.DIFFICULTY.eq(UInteger.valueOf(vo.getDifficulty())));
        }
        return condition;
    }


}
