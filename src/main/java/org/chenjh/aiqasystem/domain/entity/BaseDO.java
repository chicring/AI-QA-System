package org.chenjh.aiqasystem.domain.entity;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author hjong
 * @date 2025−01−16
 */
@Data
public class BaseDO {
    /**
     * 创建时间
     */
    private Instant createTime;

    /**
     * 最后更新时间
     */
    private Instant updateTime;

    /**
     * 创建者，username
     */
    private String creator;
}
