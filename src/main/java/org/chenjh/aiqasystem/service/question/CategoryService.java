package org.chenjh.aiqasystem.service.question;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.question.CategoryDTO;
import org.chenjh.aiqasystem.domain.vo.question.SaveCategoryVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateCategoryVO;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−22
 */
public interface CategoryService {

    /**
     * 获取分类列表
     * @param pageNum 页码
     * @param pageSize 每页数量
     * @param q 查询条件
     * @return 分类列表
     */
    PageResult<CategoryDTO> getCategoryList(Integer pageNum, Integer pageSize, String q);

    /**
     * 获取分类列表
     * @return 分类列表
     */
    List<CategoryDTO> getCategoryList();

    /**
     * 保存分类
     * @param vo 分类信息
     */
    void saveCategory(SaveCategoryVO vo);

    /**
     * 更新分类
     * @param vo 分类
     */
    void updateCategory(UpdateCategoryVO vo);


    CategoryDTO findCategoryById(Long categoryId);
}
