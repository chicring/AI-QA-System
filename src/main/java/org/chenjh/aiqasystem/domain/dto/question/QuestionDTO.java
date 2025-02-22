package org.chenjh.aiqasystem.domain.dto.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.List;

/**
 * @author hjong
 * @date 2025−02−19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {
    private Long questionId;
    private String questionTitle;
    private String questionTips;
    private Integer difficulty;
    private Integer viewCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant createTime;
    private List<String> tagNames;
}
