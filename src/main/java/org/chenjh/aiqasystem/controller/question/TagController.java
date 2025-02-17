package org.chenjh.aiqasystem.controller.question;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.chenjh.aiqasystem.config.OperationLog;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.TagDTO;
import org.chenjh.aiqasystem.domain.vo.question.AddTagVO;
import org.chenjh.aiqasystem.domain.vo.question.TagQueryVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateTagVO;
import org.chenjh.aiqasystem.service.question.TagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @RequestMapping("/add")
    @OperationLog("添加标签")
    public Result<TagDTO> addTag(@Valid AddTagVO vo) {
        return Result.ok(tagService.addTag(vo));
    }

    @GetMapping("/delete")
    @OperationLog("删除标签")
    public Result<?> deleteTag(Long id) {
        tagService.deleteTag(id);
        return Result.ok();
    }

    @PostMapping("/update")
    @OperationLog("更新标签")
    public Result<?> updateTag(@Valid @RequestBody UpdateTagVO vo) {
        tagService.updateTag(vo);
        return Result.ok();
    }

    @GetMapping("/list")
    @OperationLog("标签列表")
    public Result<PageResult<TagDTO>> getList(@Valid TagQueryVO vo) {
        return Result.ok(tagService.getTagList(vo));
    }
}
