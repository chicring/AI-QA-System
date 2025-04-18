package org.chenjh.aiqasystem.domain.dto.system.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Instant;

/**
 * @author hjong
 * @date 2025−04−13
 */
@Data
public class NotifyAdminDTO {

    private Integer id;

    private String title;

    private String content;

    /**
     * 1:系统通知 2:其它通知
     */
    private Integer type;

    /**
     * 1:未读 2:已读
     */
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Instant createTime;

    private String username;

    private String avatar;
}
