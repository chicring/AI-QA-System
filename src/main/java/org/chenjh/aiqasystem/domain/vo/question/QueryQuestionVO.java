package org.chenjh.aiqasystem.domain.vo.question;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.chenjh.aiqasystem.domain.PageQuery;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryQuestionVO extends PageQuery {

    private Long categoryId;

    private String categoryName;

    private String title;

    private Integer difficulty;

    private List<String> tagNames;
}
