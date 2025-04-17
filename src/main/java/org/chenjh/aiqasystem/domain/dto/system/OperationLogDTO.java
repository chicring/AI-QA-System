package org.chenjh.aiqasystem.domain.dto.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Instant;

/**
 * @author hjong
 * @date 2025−02−23
 */
@Data
public class OperationLogDTO {

    private Long id;

    private String content;

    private String methodName;

    private String requestParams;

    private String operator;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Instant operationTime;

    private Long timeTaken;
}
