package org.chenjh.aiqasystem.repo.system;


import com.nrapendra.jooq.tables.records.UserRecord;
import org.chenjh.aiqasystem.domain.entity.system.User;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

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
        UserRecord userRecord = dsl.selectFrom(SYS_USER).where(SYS_USER.USERNAME.eq(username)).fetchOne();
        return (ObjectUtils.isEmpty(userRecord)) ? Optional.empty() : Optional.of(userRecord);
    }
}
