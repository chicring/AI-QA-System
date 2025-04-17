package org.chenjh.aiqasystem.domain.vo.question;

import lombok.Data;

import java.util.List;

/**
 * @author hjong
 * @date 2025−04−17
 */
@Data
public class QuestionVO {

    private Long id;

    private String questionTitle;

    private String questionTips;

    private Integer difficulty;

    private String answer;

    private String categoryName;

    private List<String> tagNames;

    private Long viewCount;
}
