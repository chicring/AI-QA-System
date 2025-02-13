package org.chenjh.aiqasystem.repo.system;


import com.nrapendra.jooq.tables.records.UserRecord;
import org.chenjh.aiqasystem.domain.entity.system.User;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

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

    public User save(User user){
        UserRecord userRecord = dsl.insertInto(SYS_USER)
                .set(SYS_USER.USERNAME, user.getUsername())
                .set(SYS_USER.PASSWORD, user.getPassword())
                .returning()
                .fetchOne();
        return user;
    }
}
