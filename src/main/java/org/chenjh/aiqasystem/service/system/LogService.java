package org.chenjh.aiqasystem.service.system;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.system.OperationLogDTO;
import org.chenjh.aiqasystem.domain.vo.system.QueryOperationLogVO;

/**
 * @author hjong
 * @date 2025-01-16
 **/
public interface LogService {
    /**
     * 保存操作日志
     * @param content 操作内容
     * @param methodName 方法名
     * @param requestParams 请求参数
     * @param operator 操作者
     * @param timeTaken 耗时
     */
    void saveOperationLog(String content, String methodName, String requestParams, String operator, long timeTaken);

    /**
     * 查询操作日志
     * @param vo 查询条件
     * @return 操作日志列表
     */
    PageResult<OperationLogDTO> queryOperationLog(QueryOperationLogVO vo);
}
