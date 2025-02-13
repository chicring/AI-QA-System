package org.chenjh.aiqasystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hjong
 * @date 2025−01−10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResult<T> {
    private int page;
    private int rows;
    private long total;
    private T data;
}