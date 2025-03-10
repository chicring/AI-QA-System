package org.chenjh.aiqasystem.repo.system;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.system.NotificationDTO;
import org.chenjh.aiqasystem.domain.vo.system.QueryNotificationVO;
import org.chenjh.aiqasystem.domain.vo.system.SaveNotificationVO;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.nrapendra.jooq.Tables.SYS_NOTIFICATION;

/**
 * @author hjong
 * @date 2025−03−10
 */
@Repository
public class NotificationRepository {

    private final DSLContext dsl;

    public NotificationRepository(DSLContext dsl) {
        this.dsl = dsl;
    }


    public Optional<NotificationDTO> findById(Long id, String username){
        return dsl.select(SYS_NOTIFICATION)
                .where(SYS_NOTIFICATION.ID.eq(id).and(SYS_NOTIFICATION.USERNAME.eq(username)))
                .fetchOptionalInto(NotificationDTO.class);

    }

    public void save(SaveNotificationVO vo){
        dsl.insertInto(SYS_NOTIFICATION)
                .set(SYS_NOTIFICATION.TITLE, vo.getTitle())
                .set(SYS_NOTIFICATION.CONTENT, vo.getContent())
                .set(SYS_NOTIFICATION.TYPE, vo.getType())
                .execute();
    }

    public void updateStatus(Long id, Integer status){
        dsl.update(SYS_NOTIFICATION)
                .set(SYS_NOTIFICATION.STATUS, status)
                .where(SYS_NOTIFICATION.ID.eq(id))
                .execute();
    }

    public void delete(Long id,String username){
        dsl.update(SYS_NOTIFICATION)
                .set(SYS_NOTIFICATION.IS_DELETED, true)
                .where(SYS_NOTIFICATION.ID.eq(id))
                .and(SYS_NOTIFICATION.USERNAME.eq(username))
                .execute();
    }

    // 全部已读
    public void readAll(String username){
        dsl.update(SYS_NOTIFICATION)
                .set(SYS_NOTIFICATION.STATUS, 2)
                .where(SYS_NOTIFICATION.USERNAME.eq(username))
                .execute();
    }

    public PageResult<NotificationDTO> list(QueryNotificationVO vo, String username){

        Condition condition = queryCondition(vo, username);

        Long total = dsl.selectCount()
                .from(SYS_NOTIFICATION)
                .where(condition)
                .fetchOne(0, Long.class);

        List<NotificationDTO> list = dsl.selectFrom(SYS_NOTIFICATION)
                    .where(condition)
                    .orderBy(SYS_NOTIFICATION.CREATE_TIME.desc())
                    .limit((vo.getPageNum() - 1) * vo.getPageSize(), vo.getPageSize())
                    .fetch()
                    .into(NotificationDTO.class);

        return new PageResult<>(vo.getPageNum(), vo.getPageSize(), total, list);
    }

    private Condition queryCondition(QueryNotificationVO vo, String username){
        Condition condition = SYS_NOTIFICATION.IS_DELETED.eq(false).and(SYS_NOTIFICATION.USERNAME.eq(username));

        if (vo.getType() != null){
            condition = condition.and(SYS_NOTIFICATION.TYPE.eq(vo.getType()));
        }
        if (vo.getStatus() != null){
            condition = condition.and(SYS_NOTIFICATION.STATUS.eq(vo.getStatus()));
        }
        return condition;

    }
}
