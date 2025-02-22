package org.chenjh.aiqasystem.controller.question;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.question.CategoryDTO;
import org.chenjh.aiqasystem.domain.vo.question.SaveCategoryVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateCategoryVO;
import org.chenjh.aiqasystem.service.question.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−23
 */
@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @PostMapping()
    public Result<?> addCategory(@Valid @RequestBody SaveCategoryVO vo) {
        categoryService.saveCategory(vo);
        return Result.ok();
    }

    @PutMapping()
    public Result<?> updateCategory(@Valid @RequestBody UpdateCategoryVO vo) {
        categoryService.updateCategory(vo);
        return Result.ok();
    }

    @GetMapping("/list")
    public Result<List<CategoryDTO>> getCategoryList() {
        return Result.ok(categoryService.getCategoryList());
    }
}
