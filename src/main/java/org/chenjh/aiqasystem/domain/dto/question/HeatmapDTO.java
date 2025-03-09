package org.chenjh.aiqasystem.domain.dto.question;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * @author hjong
 * @date 2025−03−09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeatmapDTO {

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Instant date;
    private Integer count;
}
