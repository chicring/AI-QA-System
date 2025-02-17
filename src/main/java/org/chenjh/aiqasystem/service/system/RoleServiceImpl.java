package org.chenjh.aiqasystem.service.system;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.system.PermissionDTO;
import org.chenjh.aiqasystem.domain.dto.system.RoleDTO;
import org.chenjh.aiqasystem.domain.vo.RoleVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Override
    public RoleDTO addRole(RoleVO role, String username) {
        return null;
    }

    @Override
    public PageResult<RoleDTO> queryRoles(String q, int page, int pageSize) {
        return null;
    }

    @Override
    public List<PermissionDTO> getPermissions() {
        return List.of();
    }

    @Override
    public void deleteRoles(Long id) {

    }

    @Override
    public RoleDTO updateRole(RoleVO role, String username) {
        return null;
    }
}
