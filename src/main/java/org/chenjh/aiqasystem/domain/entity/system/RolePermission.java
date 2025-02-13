package org.chenjh.aiqasystem.domain.entity.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.chenjh.aiqasystem.domain.entity.BaseDO;



@EqualsAndHashCode(callSuper = true)
@Data
public class RolePermission extends BaseDO {

    private Long roleId;           // 角色ID
    private Long permissionId;     // 权限ID
}