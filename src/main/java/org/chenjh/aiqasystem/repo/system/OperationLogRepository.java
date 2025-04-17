package org.chenjh.aiqasystem.repo.system;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.system.OperationLogDTO;
import org.chenjh.aiqasystem.domain.vo.system.QueryOperationLogVO;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static com.nrapendra.jooq.tables.OperationLogTb.SYS_OPERATION_LOG;
import static org.jooq.impl.DSL.concat;

/**
 * @author hjong
 * @date 2025−02−23
 */
@Repository
public class OperationLogRepository {

    private final DSLContext dsl;

    public OperationLogRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void save(String content, String methodName, String requestParams, String operator, long timeTaken){
        dsl.insertInto(SYS_OPERATION_LOG)
                .set(SYS_OPERATION_LOG.CONTENT, content)
                .set(SYS_OPERATION_LOG.METHOD_NAME, methodName)
                .set(SYS_OPERATION_LOG.REQUEST_PARAMS, requestParams)
                .set(SYS_OPERATION_LOG.OPERATOR, operator)
                .set(SYS_OPERATION_LOG.TIME_TAKEN, timeTaken)
                .execute();
    }

    public PageResult<OperationLogDTO> queryOperationLog(QueryOperationLogVO vo) {
        Condition condition = DSL.noCondition();
        if (vo.getStartTime() != null) {
            condition = condition.and(SYS_OPERATION_LOG.OPERATION_TIME.ge(LocalDateTime.ofInstant(vo.getStartTime(), ZoneOffset.UTC)));
        }
        if (vo.getEndTime() != null) {
            condition = condition.and(SYS_OPERATION_LOG.OPERATION_TIME.le(LocalDateTime.ofInstant(vo.getEndTime(), ZoneOffset.UTC)));
        }
        if (vo.getOperator() != null) {
            condition = condition.and(SYS_OPERATION_LOG.OPERATOR.like(concat("%" + vo.getOperator() + "%")));
        }

        Long total = dsl.selectCount()
                .from(SYS_OPERATION_LOG)
                .where(condition)
                .fetchOne(0, Long.class);

        List<OperationLogDTO> list = dsl.select(SYS_OPERATION_LOG.ID,
                        SYS_OPERATION_LOG.CONTENT,
                        SYS_OPERATION_LOG.METHOD_NAME,
                        SYS_OPERATION_LOG.REQUEST_PARAMS,
                        SYS_OPERATION_LOG.OPERATOR,
                        SYS_OPERATION_LOG.TIME_TAKEN,
                        SYS_OPERATION_LOG.OPERATION_TIME)
                .from(SYS_OPERATION_LOG)
                .where(condition)
                .orderBy(SYS_OPERATION_LOG.OPERATION_TIME.desc())
                .limit(vo.getPageSize())
                .offset((vo.getPageNum() - 1) * vo.getPageSize())
                .fetchInto(OperationLogDTO.class);

        return new PageResult<>(vo.getPageNum(), vo.getPageSize(), total, list);
    }

    /**
     * 统计操作日志数量
     * @return 操作日志数量
     */
    public Long countOperationLog() {

        return dsl.selectCount()
                .from(SYS_OPERATION_LOG)
                .fetchOne(0, Long.class);
    }

    /**
     * 查询今日操作日志数量
        * @return 今日操作日志数量
     */
    public Long countTodayOperationLog() {
        LocalDateTime startOfDay = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        return dsl.selectCount()
                .from(SYS_OPERATION_LOG)
                .where(SYS_OPERATION_LOG.OPERATION_TIME.ge(startOfDay))
                .fetchOne(0, Long.class);
    }
}
