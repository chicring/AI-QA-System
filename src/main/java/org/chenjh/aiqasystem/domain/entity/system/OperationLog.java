package org.chenjh.aiqasystem.domain.entity.system;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author hjong
 * @date 2025−01−16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationLog {
    private Long id;
    private String content;
    private String methodName;
    private String requestParams;
    private String operator;
    private LocalDateTime operationTime;
    private long timeTaken;
}
