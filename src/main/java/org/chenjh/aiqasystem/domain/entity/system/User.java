package org.chenjh.aiqasystem.domain.entity.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.chenjh.aiqasystem.domain.entity.BaseDO;

import java.time.Instant;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseDO {

    private String username;       // 用户名
    private String password;       // 密码
    private String nickname;       // 昵称
    private String email;          // 邮箱
    private String mobile;         // 手机号
    private Integer sex;           // 性别：1-男性，2-女性
    private String avatar;         // 头像（Base64）
    private Boolean enabled;       // 是否启用：1-启用，0-禁用
    private String loginIp;        // 最近登录IP
    private Instant loginDate; // 最近登录时间
}