package org.chenjh.aiqasystem.domain.vo.system;

import lombok.Data;

/**
 * @author hjong
 * @date 2025−03−10
 */
@Data
public class SaveNotificationVO {

    private String title;

    private String content;

    /**
     * 1:系统通知 2:其它通知
     */
    private Integer type;
}
