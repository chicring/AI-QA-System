package org.chenjh.aiqasystem.domain.dto.system.admin;

import lombok.Data;

/**
 * @author hjong
 * @date 2025−04−13
 */
@Data
public class UserAdminDTO {
    private String username;       // 用户名
    private String nickname;       // 昵称
    private String email;          // 邮箱
    private String mobile;         // 手机号
    private Integer sex;           // 性别：1-男性，2-女性
    private String avatar;         // 头像
    private String role;           // 角色

    private String status;         // 状态：1-启用，2-禁用

    private String loginIp;         // 登录IP

    /**
     * 统计信息
     */
    private Long used_quota;        // 已使用配额

    private Long requestCount;      // 请求次数

}
