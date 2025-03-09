package org.chenjh.aiqasystem.domain.dto.question;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

/**
 * @author hjong
 * @date 2025−03−07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionHistoryDTO extends QuestionDTO {


    /**
     * 问题历史状态
     */
    private Integer status;

    /**
     * 最后查看时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Instant lastViewTime;
}
