package org.chenjh.aiqasystem.domain.dto.question;

import lombok.Data;

/**
 * @author hjong
 * @date 2025−02−19
 */
@Data
public class CategoryDTO {
    private Long id;
    private String categoryName;
    private String Description;
    private Integer categoryLevel;
    private Integer parentCategoryId;
    private Integer sortNum;
    private String imageUrl;
}
