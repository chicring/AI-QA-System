package org.chenjh.aiqasystem.repo.system;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.system.NotificationDTO;
import org.chenjh.aiqasystem.domain.vo.system.QueryNotificationVO;
import org.chenjh.aiqasystem.domain.vo.system.SaveNotificationVO;
import org.chenjh.aiqasystem.domain.vo.system.SendNotifyVO;
import org.jooq.Condition;
import org.jooq.impl.DSL;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.chenjh.aiqasystem.domain.dto.system.admin.NotifyAdminDTO;

import static com.nrapendra.jooq.Tables.SYS_NOTIFICATION;
import static com.nrapendra.jooq.Tables.SYS_USER;

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

    public void save(SendNotifyVO vo){
        dsl.insertInto(SYS_NOTIFICATION)
                .set(SYS_NOTIFICATION.TITLE, vo.getTitle())
                .set(SYS_NOTIFICATION.CONTENT, vo.getContent())
                .set(SYS_NOTIFICATION.USERNAME, vo.getUsername())
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


    // 管理端查询通知
    public PageResult<NotifyAdminDTO> pageForAdmin(QueryNotificationVO vo){
        Condition condition = DSL.noCondition();

        if (vo.getStatus() != null){
            condition = condition.and(SYS_NOTIFICATION.STATUS.eq(vo.getStatus()));
        }

        Long total = dsl.selectCount()
                .from(SYS_NOTIFICATION)
                .where(condition)
                .fetchOne(0, Long.class);

        List<NotifyAdminDTO> list = dsl.select(
                    SYS_NOTIFICATION.ID,
                    SYS_NOTIFICATION.TITLE,
                    SYS_NOTIFICATION.CONTENT,
                    SYS_NOTIFICATION.TYPE,
                    SYS_NOTIFICATION.STATUS,
                    SYS_NOTIFICATION.CREATE_TIME,
                    SYS_USER.USERNAME,
                    SYS_USER.AVATAR
                )
                .from(SYS_NOTIFICATION)
                .leftJoin(SYS_USER)
                .on(SYS_NOTIFICATION.USERNAME.eq(SYS_USER.USERNAME))
                .where(condition)
                .orderBy(SYS_NOTIFICATION.CREATE_TIME.desc())
                .limit((vo.getPageNum() - 1) * vo.getPageSize(), vo.getPageSize())
                .fetch()
                .into(NotifyAdminDTO.class);
                
        return new PageResult<>(vo.getPageNum(), vo.getPageSize(), total, list);
    }
}
