package org.chenjh.aiqasystem.repo.system;

import com.nrapendra.jooq.Tables;
import com.nrapendra.jooq.tables.records.RolePermissionRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.nrapendra.jooq.Tables.*;

@Repository
public class RolePermissionRepository {

    private final DSLContext dsl;

    public RolePermissionRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    /**
     * 根据角色id列表查询权限id列表
     * @param roleIds 角色id列表
     * @return 权限id列表
     */
    public List<RolePermissionRecord> queryPermissionIdsByRoleIds(List<Long> roleIds) {

        return dsl.selectFrom(SYS_ROLE_PERMISSION)
                .where(SYS_ROLE_PERMISSION.ROLE_ID.in(roleIds))
                .fetch();
    }
    /**
     * 根据角色id查询权限id列表
     * @param roleId 角色id
     * @return 权限id列表
     */
    public List<RolePermissionRecord> queryPermissionIdsByRoleId(Long roleId) {
        return dsl.selectFrom(SYS_ROLE_PERMISSION)
                .where(SYS_ROLE_PERMISSION.ROLE_ID.eq(roleId))
                .fetch();
    }

    /**
     * 删除角色权限信息
     * @param roleId 角色id
     */
    public int deleteByRoleId(Long roleId) {
        return dsl.deleteFrom(SYS_ROLE_PERMISSION)
                .where(SYS_ROLE_PERMISSION.ROLE_ID.eq(roleId))
                .execute();
    }

    /**
     * 根据用户账号查询权限范围
     * @param username 用户账号
     * @return 权限范围列表
     */
    public List<String> queryPermissionScopeByUserId(String username) {
        return dsl.selectDistinct(SYS_PERMISSION.SCOPE)
                .from(SYS_ROLE_PERMISSION)
                .join(SYS_ROLE).on(SYS_ROLE.ID.eq(SYS_ROLE_PERMISSION.ROLE_ID))
                .join(SYS_USER_ROLE).on(SYS_USER_ROLE.ROLE_ID.eq(SYS_ROLE.ID))
                .where(SYS_USER_ROLE.USERNAME.eq(username))
                .fetchInto(String.class);
    }
}
