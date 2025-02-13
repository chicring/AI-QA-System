package org.chenjh.aiqasystem.domain.entity.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.chenjh.aiqasystem.domain.entity.BaseDO;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserRole extends BaseDO {
    private Long id;               // 主键ID
    private String username;       // 用户名
    private Long roleId;           // 角色ID
}