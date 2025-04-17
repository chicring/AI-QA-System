package org.chenjh.aiqasystem.domain.dto.system;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hjong
 * @date 2025−04−13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SystemInfoDTO {

    /**
     * 题库数量
     */
    private Long questionCount;

    /**
     * 用户数量
     */
    private Long userCount;

    /**
     * 今日日志数量
     */
    private Long todayLogCount;

    /**
     * 总共日志数量
     */
    private Long totalLogCount;

}
