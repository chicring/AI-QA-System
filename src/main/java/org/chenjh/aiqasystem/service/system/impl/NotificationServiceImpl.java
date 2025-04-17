package org.chenjh.aiqasystem.service.system.impl;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.system.NotificationDTO;
import org.chenjh.aiqasystem.domain.vo.system.QueryNotificationVO;
import org.chenjh.aiqasystem.domain.vo.system.SaveNotificationVO;
import org.chenjh.aiqasystem.domain.vo.system.SendNotifyVO;
import org.chenjh.aiqasystem.exception.custom.ResourceNotFoundException;
import org.chenjh.aiqasystem.repo.system.NotificationRepository;
import org.chenjh.aiqasystem.domain.dto.system.admin.NotifyAdminDTO;
import org.chenjh.aiqasystem.service.system.NotificationService;
import org.springframework.stereotype.Service;

/**
 * @author hjong
 * @date 2025−03−10
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    @Resource
    private NotificationRepository notificationRepository;

    @Override
    public NotificationDTO queryById(Long id, String username) {
        return notificationRepository.findById(id, username).orElseThrow(
                () -> new ResourceNotFoundException("通知不存在")
        );
    }

    @Override
    public void save(SendNotifyVO vo) {
        notificationRepository.save(vo);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        notificationRepository.updateStatus(id, status);
    }

    @Override
    public void delete(Long id,String username) {
        notificationRepository.delete(id, username);
    }

    @Override
    public PageResult<NotificationDTO> list(QueryNotificationVO vo, String username) {
        return notificationRepository.list(vo, username);
    }

    @Override
    public void readAll(String username) {
        notificationRepository.readAll(username);
    }

    @Override
    public PageResult<NotifyAdminDTO> pageForAdmin(QueryNotificationVO vo) {
        return notificationRepository.pageForAdmin(vo);
    }
}
