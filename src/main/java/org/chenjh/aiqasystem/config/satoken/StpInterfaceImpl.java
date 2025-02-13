package org.chenjh.aiqasystem.config.satoken;

import cn.dev33.satoken.stp.StpInterface;
import org.chenjh.aiqasystem.repo.system.PermissionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hjong
 * @date 2025−01−16
 */
@Component
public class StpInterfaceImpl  implements StpInterface {

    private final PermissionRepository permissionRepository;

    public StpInterfaceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }


    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return permissionRepository.findAll();
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return List.of();
    }
}
