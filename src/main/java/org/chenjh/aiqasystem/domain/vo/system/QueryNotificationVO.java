package org.chenjh.aiqasystem.domain.vo.system;

import lombok.Data;

/**
 * @author hjong
 * @date 2025−03−10
 */
@Data
public class QueryNotificationVO {

    private Integer pageNum;

    private Integer pageSize;

    private Integer status;

    private Integer type;
}
