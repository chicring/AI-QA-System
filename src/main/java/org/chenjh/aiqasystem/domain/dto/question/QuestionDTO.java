package org.chenjh.aiqasystem.domain.dto.question;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    private Long id;

    private String questionTitle;

    private String questionTips;

    private Integer difficulty;

    private String answer;

    private String categoryName;

    private List<String> tagNames;

    private Long viewCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Instant createTime;
}
