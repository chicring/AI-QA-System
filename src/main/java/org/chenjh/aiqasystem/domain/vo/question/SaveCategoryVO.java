package org.chenjh.aiqasystem.domain.vo.question;

import lombok.Data;

/**
 * @author hjong
 * @date 2025−02−19
 */
@Data
public class SaveCategoryVO {
    private String categoryName;
    private String description;
    private Integer categoryLevel;
    private Long parentCategoryId;
    private Integer sortNum;
    private String imageUrl;
}
