package org.chenjh.aiqasystem.domain.dto.question;

import lombok.Data;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−20
 */
@Data
public class TagGroupDTO {
    private String categoryName;
    private List<String> tagNames;
}
