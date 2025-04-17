package org.chenjh.aiqasystem.domain;

import lombok.Data;

/**
 * @author hjong
 * @date 2025−04−17
 */
@Data
public class PageQuery {
    private Integer pageNum     = 1;
    private Integer pageSize    = 10;
}
