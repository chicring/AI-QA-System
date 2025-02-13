package org.chenjh.aiqasystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private Long id;
    private String title;
    private String solution;
    private Integer difficultyLevel;
    private Integer viewCount;
    private String creator;
    private Long creatorId;
    private List<TagDTO> tags;
}
