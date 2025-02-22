package org.chenjh.aiqasystem.controller.question;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.chenjh.aiqasystem.config.OperationLog;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.question.TagGroupDTO;
import org.chenjh.aiqasystem.domain.vo.question.SaveTagVO;

import org.chenjh.aiqasystem.domain.vo.question.UpdateTagVO;
import org.chenjh.aiqasystem.service.question.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @PostMapping()
    @OperationLog("添加标签")
    public Result<?> addTag(@Valid SaveTagVO vo) {
        tagService.saveTag(vo);
        return Result.ok();
    }

    @DeleteMapping("/{id}")
    @OperationLog("删除标签")
    public Result<?> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return Result.ok();
    }

    @PutMapping()
    @OperationLog("更新标签")
    public Result<?> updateTag(@Valid @RequestBody UpdateTagVO vo) {
        tagService.updateTag(vo);
        return Result.ok();
    }

    @GetMapping("/list-group")
    @OperationLog("标签分组列表")
    public Result<List<TagGroupDTO>> getListGroup() {
        return Result.ok(tagService.getTagGroup());
    }
}
