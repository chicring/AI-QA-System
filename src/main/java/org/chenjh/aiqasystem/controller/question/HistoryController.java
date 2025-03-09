package org.chenjh.aiqasystem.controller.question;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.question.HeatmapDTO;
import org.chenjh.aiqasystem.domain.dto.question.QuestionHistoryDTO;
import org.chenjh.aiqasystem.domain.vo.question.QueryHistoryVO;
import org.chenjh.aiqasystem.service.question.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hjong
 * @date 2025−03−07
 */
@RestController
@RequestMapping("/v1/history")
public class HistoryController {

    @Resource
    private HistoryService historyService;

    /**
     * 查询历史记录
     * @param vo 查询条件
     * @return 分页历史记录
     */
    @GetMapping("/list")
    public Result<PageResult<QuestionHistoryDTO>> list(
            QueryHistoryVO vo
    ) {
        String username = StpUtil.getLoginIdAsString();
        return Result.ok(historyService.queryHistory(vo, username));
    }

    /**
     * 标记历史记录
     * @return 清空结果
     */
    @PutMapping("/{id}")
    public Result<?> mark(@PathVariable Long id, @RequestParam Integer status) {
        historyService.updateHistory(id, StpUtil.getLoginIdAsString(), status);
        return Result.ok();
    }

    /**
     * 删除历史记录
     * @param id 历史记录id
     * @return 删除结果
     */
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        historyService.deleteHistory(id, StpUtil.getLoginIdAsString());
        return Result.ok();
    }

    /**
     * 获取热力图数据
     * @return 热力图数据
     */
    @GetMapping("/heatmap")
    public Result<List<HeatmapDTO>> getHeatmapData() {
        return Result.ok(historyService.getHeatmapData(StpUtil.getLoginIdAsString()));
    }
}
