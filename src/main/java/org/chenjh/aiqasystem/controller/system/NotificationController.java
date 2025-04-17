package org.chenjh.aiqasystem.controller.system;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.system.NotificationDTO;
import org.chenjh.aiqasystem.domain.dto.system.admin.NotifyAdminDTO;
import org.chenjh.aiqasystem.domain.vo.system.QueryNotificationVO;
import org.chenjh.aiqasystem.domain.vo.system.SendNotifyVO;
import org.chenjh.aiqasystem.service.system.NotificationService;
import org.springframework.web.bind.annotation.*;

/**
 * @author hjong
 * @date 2025−03−10
 */
@RestController
@RequestMapping("/v1/notice")
public class NotificationController {

    @Resource
    private NotificationService notificationService;

    /**
     * 根据id查询通知
     */
    @GetMapping("/{id}")
    public Result<NotificationDTO> getNotificationById(@PathVariable Long id) {
        return Result.ok(notificationService.queryById(id, StpUtil.getLoginIdAsString()));
    }

    /**
     * 根据id更新通知状态
     */
    @GetMapping("/status/{id}")
    public Result<?> updateNotificationStatus(@PathVariable Long id,
                                              @RequestParam Integer status) {
        notificationService.updateStatus(id, status);
        return Result.ok();
    }

    /**
     * 删除通知
     */
    @DeleteMapping("/{id}")
    public Result<?> deleteNotification(@PathVariable Long id) {
        notificationService.delete(id, StpUtil.getLoginIdAsString());
        return Result.ok();
    }

    /**
     * 分页查询通知
     */
    @GetMapping("/list")
    public Result<PageResult<NotificationDTO>> listNotification(QueryNotificationVO vo) {
        return Result.ok(notificationService.list(vo, StpUtil.getLoginIdAsString()));
    }

    /**
     * 标记所有通知已读
     */
    @PutMapping("/mark-all-read")
    public Result<?> readAllNotification() {
        notificationService.readAll(StpUtil.getLoginIdAsString());
        return Result.ok();
    }

    /**
     * 管理端分页查询通知
     */
    @GetMapping("/admin/page")
    public Result<PageResult<NotifyAdminDTO>> pageForAdmin(QueryNotificationVO vo) {
        return Result.ok(notificationService.pageForAdmin(vo));
    }

    /**
     * 管理端发送通知
     */
    @PostMapping("/admin/send")
    public Result<?> sendNotification(@RequestBody SendNotifyVO vo) {
        notificationService.save(vo);
        return Result.ok();
    }
}
