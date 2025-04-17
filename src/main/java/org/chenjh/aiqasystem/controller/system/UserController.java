package org.chenjh.aiqasystem.controller.system;


import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.chenjh.aiqasystem.config.OperationLog;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.system.UserInfoDTO;
import org.chenjh.aiqasystem.domain.dto.system.UserTokenDTO;
import org.chenjh.aiqasystem.domain.dto.system.admin.UserAdminDTO;
import org.chenjh.aiqasystem.domain.vo.system.UserLoginVO;
import org.chenjh.aiqasystem.domain.vo.system.UserRegisterVO;
import org.chenjh.aiqasystem.service.system.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @OperationLog("用户列表")
    @GetMapping("/admin/page")
    Result<PageResult<UserAdminDTO>> page(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer size,
                              @RequestParam(required = false) String username) {
        return Result.ok(userService.pageForAdmin(page, size, username));
    }
}
