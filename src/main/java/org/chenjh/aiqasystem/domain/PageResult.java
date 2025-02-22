package org.chenjh.aiqasystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author hjong
 * @date 2025−01−10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResult<T> {
    private int pageNum;
    private int pageSize;
    private Long total;
    private List<T> data;
}