package org.chenjh.aiqasystem.repo.system;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.nrapendra.jooq.Tables.SYS_USER_ROLE;

@Repository
public class UserRoleRepository {

    private final DSLContext dsl;

    UserRoleRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    /**
     * 保存用户角色
     * @param username 用户名
     * @param roleId 角色ID
     * @return 影响行数
     */
    public int save(String username, Long roleId) {
        return dsl.insertInto(SYS_USER_ROLE)
                .set(SYS_USER_ROLE.USERNAME, username)
                .set(SYS_USER_ROLE.ROLE_ID, roleId)
                .execute();
    }

    /**
     * 根据用户账号删除用户角色信息
     * @param username 用户账号
     */
//    public boolean changePassword(String username, String password) {
//        return dsl.update(SYS_USER_ROLE)
//                .set(SYS_USER_ROLE.PASSWORD, password)
//                .where(SYS_USER_ROLE.USERNAME.eq(username))
//                .execute() > 0;
//    }

    /**
     * 根据用户账号删除用户角色信息
     * @param username 用户账号
     */
    public int delete(String username) {
        return dsl.deleteFrom(SYS_USER_ROLE)
                .where(SYS_USER_ROLE.USERNAME.eq(username))
                .execute();
    }

    /**
     * 根据角色id删除用户角色关系
     * @param roleId 角色id
     */
    public int deleteByRoleId(Long roleId) {
        return dsl.deleteFrom(SYS_USER_ROLE)
                .where(SYS_USER_ROLE.ROLE_ID.eq(roleId))
                .execute();
    }

    /**
     * 根据角色id更新用户角色关系
     * @param roleId 角色id
     */
    public int updateByRoleId(Long roleId, String username) {
        return dsl.update(SYS_USER_ROLE)
                .set(SYS_USER_ROLE.USERNAME, username)
                .where(SYS_USER_ROLE.ROLE_ID.eq(roleId))
                .execute();
    }
}
