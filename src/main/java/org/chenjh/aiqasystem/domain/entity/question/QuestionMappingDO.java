package org.chenjh.aiqasystem.domain.entity.question;

import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.chenjh.aiqasystem.domain.entity.BaseDO;

/**
 * @author hjong
 * @date 2025−04−17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table("qa_question_mapping")
public class QuestionMappingDO extends BaseDO {

    private Long id;

    private Long questionId;

    private Long categoryId;

    private Long tagId;
}
