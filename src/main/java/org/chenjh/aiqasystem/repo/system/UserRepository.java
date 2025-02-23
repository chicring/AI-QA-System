package org.chenjh.aiqasystem.repo.system;


import com.nrapendra.jooq.tables.records.UserRecord;
import org.chenjh.aiqasystem.domain.dto.system.UserInfoDTO;
import org.chenjh.aiqasystem.domain.vo.system.ChangePasswordVO;
import org.chenjh.aiqasystem.domain.vo.system.UpdateUserVO;
import org.chenjh.aiqasystem.domain.vo.system.UserRegisterVO;
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


    public Integer save(UserRegisterVO vo){
        return dsl.insertInto(SYS_USER)
                .set(SYS_USER.USERNAME, vo.getUsername())
                .set(SYS_USER.PASSWORD, vo.getPassword())
                .set(SYS_USER.NICKNAME, vo.getNickname())
                .set(SYS_USER.EMAIL, vo.getEmail())
                .set(SYS_USER.MOBILE, vo.getMobile())
                .set(SYS_USER.SEX, vo.getSex())
                .execute();
    }

    public Optional<UserRecord> findUser(String username){
        return dsl.selectFrom(SYS_USER).where(SYS_USER.USERNAME.eq(username)).fetchOptional();
    }

    public Optional<UserInfoDTO> findByUsername(String username){
        return dsl.selectFrom(SYS_USER).where(SYS_USER.USERNAME.eq(username)).fetchOptionalInto(UserInfoDTO.class);
    }

    public Boolean changePassword(String username, ChangePasswordVO vo) {
        return dsl.update(SYS_USER)
                .set(SYS_USER.PASSWORD, vo.getNewPassword())
                .where(SYS_USER.USERNAME.eq(username))
                .and(SYS_USER.PASSWORD.eq(vo.getOldPassword()))
                .execute() > 0;
    }

    public Boolean updateUserInfo(String username, UpdateUserVO vo) {
        UserRecord userRecord = dsl.selectFrom(SYS_USER).where(SYS_USER.USERNAME.eq(username)).fetchSingle();;

        if(vo.getNickname() != null && !vo.getNickname().isEmpty()){
            userRecord.setNickname(vo.getNickname());
        }
        if(vo.getEmail() != null && !vo.getEmail().isEmpty()){
            userRecord.setEmail(vo.getEmail());
        }
        if(vo.getMobile() != null && !vo.getMobile().isEmpty()){
            userRecord.setMobile(vo.getMobile());
        }
        if(vo.getSex() != null){
            userRecord.setSex(vo.getSex());
        }
        if(vo.getAvatar() != null && !vo.getAvatar().isEmpty()){
            userRecord.setAvatar(vo.getAvatar());
        }

        return userRecord.update() > 0;
    }
}
