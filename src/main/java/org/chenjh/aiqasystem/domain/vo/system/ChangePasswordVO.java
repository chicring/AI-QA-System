package org.chenjh.aiqasystem.domain.vo.system;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author hjong
 * @date 2025−02−23
 */
@Data
public class ChangePasswordVO {

    @Pattern(regexp = "^[a-zA-Z0-9_]{4,16}$", message = "用户账号由 数字、字母、下划线 组成")
    @Size(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String oldPassword;

    @Pattern(regexp = "^[a-zA-Z0-9_]{4,16}$", message = "用户账号由 数字、字母、下划线 组成")
    @Size(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String newPassword;
}
