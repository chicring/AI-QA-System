package org.chenjh.aiqasystem.repo.system;


import com.nrapendra.jooq.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;


import java.util.Optional;

import static com.nrapendra.jooq.Tables.SYS_USER;


/**
 * @author hjong
 * @date 2025−01−13
 */
@Repository
public class UserRepository {
    private final DSLContext dsl;

    UserRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public int save(UserRecord user){
        return dsl.newRecord(SYS_USER,user).store();
    }


    public Optional<UserRecord> findByUsername(String username){

        return dsl.selectFrom(SYS_USER).where(SYS_USER.USERNAME.eq(username)).fetchOptional();
    }
}
