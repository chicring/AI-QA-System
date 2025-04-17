package org.chenjh.aiqasystem.controller.system;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.config.OperationLog;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.system.SystemInfoDTO;
import org.chenjh.aiqasystem.service.system.SystemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjong
 * @date 2025−04−13
 */
@RestController
@RequestMapping("/v1/system")
public class SystemController {

    @Resource
    private SystemService systemService;


    /**
     * 查询系统信息
     */
    @GetMapping("/info")
    public Result<SystemInfoDTO> getSystemInfo() {
        return Result.ok(systemService.querySystemInfo());
    }


}
