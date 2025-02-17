package org.chenjh.aiqasystem.repo.system;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepository {

    private final DSLContext dsl;

    RoleRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

}
