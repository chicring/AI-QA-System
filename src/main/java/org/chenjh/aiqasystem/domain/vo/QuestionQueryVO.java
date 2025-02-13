package org.chenjh.aiqasystem.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−14
 */
@Data
public class QuestionQueryVO {
    private Integer pageNum;
    private Integer pageSize;
    private String title;
    private Integer difficulty;
    private List<Long> tagIds;
}
