package org.chenjh.aiqasystem.domain.dto.system;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

    private String username;       // 用户名
    private String nickname;       // 昵称
    private String email;          // 邮箱
    private String mobile;         // 手机号
    private Integer sex;           // 性别：1-男性，2-女性
    private String avatar;         // 头像（Base64）
    private Set<RoleDTO> roles;            // 角色
}
