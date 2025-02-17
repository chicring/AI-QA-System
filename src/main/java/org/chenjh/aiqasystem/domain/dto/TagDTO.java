package org.chenjh.aiqasystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagDTO {
    private Long tagId;
    private String tagName;
    private Integer sort;
    private Integer parentTagId;
}
