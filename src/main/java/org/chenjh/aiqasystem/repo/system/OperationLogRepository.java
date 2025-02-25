package org.chenjh.aiqasystem.repo.system;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.nrapendra.jooq.tables.OperationLogTb.SYS_OPERATION_LOG;

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
}
