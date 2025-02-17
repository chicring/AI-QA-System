package org.chenjh.aiqasystem.service.system;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.system.PermissionDTO;
import org.chenjh.aiqasystem.domain.dto.system.RoleDTO;
import org.chenjh.aiqasystem.domain.vo.RoleVO;

import java.util.List;

public interface RoleService {

    /**
     * 添加角色
     * @param role 角色信息
     * @param username 操作人
     * @return 角色信息
     */
    RoleDTO addRole(RoleVO role, String username);

    /**
     * 查询角色
     * @param q 搜索条件
     * @param page 第几页
     * @param pageSize 返回条数
     * @return 角色信息
     */
    PageResult<RoleDTO> queryRoles(String q, int page, int pageSize);

    /**
     * 获取权限
     * @return 权限列表
     */
    List<PermissionDTO> getPermissions();

    /**
     * 删除角色
     * @param id 角色id
     */
    void deleteRoles(Long id);

    /**
     * 更新角色
     * @param role 角色信息
     * @param username 当前用户账号
     * @return 角色信息
     */
    RoleDTO updateRole(RoleVO role, String username);
}
