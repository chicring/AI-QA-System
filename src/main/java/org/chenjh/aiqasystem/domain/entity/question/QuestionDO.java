package org.chenjh.aiqasystem.domain.entity.question;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
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
@Table("qa_question")
public class QuestionDO extends BaseDO {

    @Id(keyType = KeyType.Auto)
    private Long id;

    private String questionTitle;

    private String questionTips;

    private Integer difficulty;

    private String answer;

    private String categoryName;

    private String tagNames;

    private Long viewCount;
}
