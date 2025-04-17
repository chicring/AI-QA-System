package org.chenjh.aiqasystem.domain.vo.system;

import lombok.Data;

import java.time.Instant;

/**
 * @author hjong
 * @date 2025−04−10
 */
@Data
public class QueryOperationLogVO {

    private Integer pageNum;

    private Integer pageSize;

    private String operator;

    private Instant startTime;

    private Instant endTime;
}
