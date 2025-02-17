package org.chenjh.aiqasystem.repo.system;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.nrapendra.jooq.tables.PermissionTb.SYS_PERMISSION;

/**
 * @author hjong
 * @date 2025−01−16
 */
@Repository
public class PermissionRepository {

    private final DSLContext dsl;

    public PermissionRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    /**
     * 查询所有权限
     * @return 权限列表
     */
    public List<String> findAll(){
        return dsl.selectFrom(SYS_PERMISSION).fetch(SYS_PERMISSION.SCOPE);
    }
}
