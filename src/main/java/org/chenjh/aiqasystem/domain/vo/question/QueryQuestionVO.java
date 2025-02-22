package org.chenjh.aiqasystem.domain.vo.question;

import lombok.Data;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−14
 */
@Data
public class QueryQuestionVO {

    private Integer pageNum;
    private Integer pageSize;

    private Long categoryId;
    private String title;
    private Integer difficulty;
    private List<String> tagNames;
}
