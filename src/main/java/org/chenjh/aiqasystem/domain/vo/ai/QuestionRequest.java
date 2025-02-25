package org.chenjh.aiqasystem.domain.vo.ai;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author hjong
 * @date 2025−02−26
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionRequest extends ChatRequest{
    private String question;
}
