package org.chenjh.aiqasystem.config.satoken;

import cn.dev33.satoken.stp.StpInterface;
import org.chenjh.aiqasystem.repo.system.PermissionRepository;
import org.chenjh.aiqasystem.repo.system.RolePermissionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hjong
 * @date 2025−01−16
 */
@Component
public class StpInterfaceImpl  implements StpInterface {



    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }
}
