package org.chenjh.aiqasystem.domain.vo.system;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author hjong
 * @date 2025−04−13
 */
@Data
public class SendNotifyVO {
    @NotBlank(message = "标题不能为空")
    private String title;

    @NotBlank(message = "内容不能为空")
    private String content;

    @NotBlank(message = "接收人不能为空")
    private String username;
}
