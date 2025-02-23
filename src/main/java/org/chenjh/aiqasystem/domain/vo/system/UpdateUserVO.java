package org.chenjh.aiqasystem.domain.vo.system;

import lombok.Data;

/**
 * @author hjong
 * @date 2025−02−23
 */
@Data
public class UpdateUserVO {

    private String nickname;       // 昵称
    private String email;          // 邮箱
    private String mobile;         // 手机号
    private Integer sex;           // 性别：1-男性，2-女性
    private String avatar;         // 头像（Base64）
}
