package org.chenjh.aiqasystem.domain.vo.question;

import lombok.Data;

/**
 * @author hjong
 * @date 2025−03−07
 */
@Data
public class QueryHistoryVO {

    private Integer pageNum;
    private Integer pageSize;

    /**
     * 题目状态
     */
    private Integer status;

    /**
     * 查询题目关键字
     */
    private String q;

    /**
     * 题目难度
     */
    private Integer difficulty;
}
