package org.chenjh.aiqasystem.domain.dto.question;

import lombok.Data;

/**
 * @author hjong
 * @date 2025−02−19
 */
@Data
public class TagDTO {
    private Long id;
    private String tagName;
    private Integer sortNum;
    private Long categoryId;
    private String categoryName;
}
