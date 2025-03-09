package org.chenjh.aiqasystem.service.question.impl;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.question.CategoryDTO;
import org.chenjh.aiqasystem.domain.vo.question.SaveCategoryVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateCategoryVO;
import org.chenjh.aiqasystem.repo.question.CategoryRepository;
import org.chenjh.aiqasystem.service.question.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−22
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public PageResult<CategoryDTO> getCategoryList(Integer pageNum, Integer pageSize, String q) {
        return categoryRepository.findPage(pageNum, pageSize, q);
    }

    @Override
    public List<CategoryDTO> getCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(SaveCategoryVO vo) {
        categoryRepository.save(vo);
    }

    @Override
    public void updateCategory(UpdateCategoryVO vo) {
        categoryRepository.update(vo);
    }

    @Override
    public CategoryDTO findCategoryById(Long categoryId) {
        return categoryRepository.findCategoryById(categoryId).orElseThrow(
                () -> new RuntimeException("题库分类不存在")
        );
    }
}
