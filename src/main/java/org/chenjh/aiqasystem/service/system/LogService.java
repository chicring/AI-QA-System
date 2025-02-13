package org.chenjh.aiqasystem.service.system;

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
     * @param q 查询条件
     * @param page
     * @param pageSize
     * @return
     */
//    PageResult<List<OperationLogVO>> queryOperationLog(String q, int page, int pageSize);
}
