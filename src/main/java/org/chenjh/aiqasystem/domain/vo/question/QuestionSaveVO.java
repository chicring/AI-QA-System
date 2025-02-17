package org.chenjh.aiqasystem.domain.vo.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionSaveVO {
    private String title;
    private String solution;
    private Integer difficultyLevel;
    private String tags;
    private String creator;
    private Long creatorId;
}
