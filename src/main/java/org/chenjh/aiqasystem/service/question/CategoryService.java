package org.chenjh.aiqasystem.service.question;

import org.chenjh.aiqasystem.domain.vo.question.SaveCategoryVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateCategoryVO;

/**
 * @author hjong
 * @date 2025−02−22
 */
public interface CategoryService {

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
}
