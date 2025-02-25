package org.chenjh.aiqasystem.domain.dto.question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDTO {
    Long questionId;
    List<String> questionAnswers;
}
