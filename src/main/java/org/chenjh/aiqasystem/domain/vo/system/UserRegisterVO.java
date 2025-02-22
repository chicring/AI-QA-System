package org.chenjh.aiqasystem.domain.vo.system;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterVO {
    @NotBlank(message = "用户账号不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9]{4,30}$", message = "用户账号由 数字、字母 组成")
    @Size(min = 4, max = 30, message = "用户账号长度为 4-30 个字符")
    private String username;       // 用户名

    @Pattern(regexp = "^[a-zA-Z0-9_]{4,16}$", message = "用户账号由 数字、字母、下划线 组成")
    @Size(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;       // 密码

    @Size(min = 2, max = 16, message = "用户昵称长度为 2-16 个字符")
    private String nickname;       // 昵称

    private String email;          // 邮箱
    private String mobile;         // 手机号

    /// 性别：1-男性，2-女性
    @Max(value = 2, message = "性别：1-男性，2-女性")
    @Min(value = 1, message = "性别：1-男性，2-女性")
    private Integer sex;           // 性别：1-男性，2-女性
}
