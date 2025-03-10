package org.chenjh.aiqasystem.service.system;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.system.NotificationDTO;
import org.chenjh.aiqasystem.domain.vo.system.QueryNotificationVO;
import org.chenjh.aiqasystem.domain.vo.system.SaveNotificationVO;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.nrapendra.jooq.Tables.SYS_NOTIFICATION;

/**
 * @author hjong
 * @date 2025−03−10
 */
public interface NotificationService {

    NotificationDTO queryById(Long id, String username);

    void save(SaveNotificationVO vo);

    void updateStatus(Long id, Integer status);

    void delete(Long id,String username);

    PageResult<NotificationDTO> list(QueryNotificationVO vo, String username);

    void readAll(String username);

}
