package org.chenjh.aiqasystem.controller.system;


import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.chenjh.aiqasystem.config.OperationLog;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.system.UserInfoDTO;
import org.chenjh.aiqasystem.domain.dto.system.UserTokenDTO;
import org.chenjh.aiqasystem.domain.vo.UserLoginVO;
import org.chenjh.aiqasystem.domain.vo.UserRegisterVO;
import org.chenjh.aiqasystem.service.system.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @OperationLog("用户注册")
    @PostMapping("/register")
    public Result<UserInfoDTO> register(@Valid @RequestBody UserRegisterVO vo) {
        return Result.ok(userService.register(vo));
    }

    @OperationLog("用户登录")
    @PostMapping("/login")
    public Result<UserTokenDTO> login(@Valid @RequestBody UserLoginVO vo) {
        return Result.ok(userService.login(vo));
    }

    @OperationLog("获取用户信息")
    @GetMapping("/getUserInfoByName")
    public Result<UserInfoDTO> getUserInfoByName(String userName) {
        return Result.ok(userService.getUserInfoByName(userName));
    }

}
