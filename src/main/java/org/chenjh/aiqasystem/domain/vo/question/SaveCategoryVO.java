package org.chenjh.aiqasystem.domain.vo.question;

import lombok.Data;

/**
 * @author hjong
 * @date 2025−02−19
 */
@Data
public class SaveCategoryVO {
    private String categoryName;
    private String Description;
    private Integer categoryLevel;
    private Long parentCategoryId;
    private Integer sortNum;
    private String imageUrl;
}
