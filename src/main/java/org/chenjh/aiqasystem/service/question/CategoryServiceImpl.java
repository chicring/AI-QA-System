package org.chenjh.aiqasystem.service.question;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.dto.question.CategoryDTO;
import org.chenjh.aiqasystem.domain.vo.question.SaveCategoryVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateCategoryVO;
import org.chenjh.aiqasystem.repo.question.CategoryRepository;
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
}
