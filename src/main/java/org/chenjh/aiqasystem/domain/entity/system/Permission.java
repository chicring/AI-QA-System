package org.chenjh.aiqasystem.domain.entity.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.chenjh.aiqasystem.domain.entity.BaseDO;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class Permission extends BaseDO {

    private Long id;               // 权限ID
    private String name;           // 权限名称
    /**
     * 权限标识
     * 一般格式为：${系统}:${模块}:${操作}
     * 例如说：system:admin:add，即 system 服务的添加管理员。
     * 当我们把该 MenuDO 赋予给角色后，意味着该角色有该资源：
     * - 对于后端，配合 @PreAuthorize 注解，配置 API 接口需要该权限，从而对 API 接口进行权限控制。
     * - 对于前端，配合前端标签，配置按钮是否展示，避免用户没有该权限时，结果可以看到该操作。
     */
    private String scope;          // 权限范围
}