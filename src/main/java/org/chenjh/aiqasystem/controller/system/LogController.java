package org.chenjh.aiqasystem.controller.system;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.config.OperationLog;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.system.OperationLogDTO;
import org.chenjh.aiqasystem.domain.vo.system.QueryOperationLogVO;
import org.chenjh.aiqasystem.service.system.LogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjong
 * @date 2025−04−10
 */
@RestController
@RequestMapping("/v1/log")
public class LogController {

    @Resource
    private LogService logService;

    /**
     * 查询操作日志
     * @param vo 查询条件
     * @return 操作日志列表
     */
    @RequestMapping("/page")
    public Result<PageResult<OperationLogDTO>> queryOperationLog(QueryOperationLogVO vo) {
        return Result.ok(logService.queryOperationLog(vo));
    }
}
