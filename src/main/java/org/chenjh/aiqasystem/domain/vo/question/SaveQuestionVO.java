package org.chenjh.aiqasystem.domain.vo.question;

import lombok.Data;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−20
 */
@Data
public class SaveQuestionVO {

    private String questionTitle;
    private String questionTips;
    private Integer difficulty;
    private Long categoryId;
    private List<Long> tagIds;
    private List<String> answers;
}
