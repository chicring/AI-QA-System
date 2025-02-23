package org.chenjh.aiqasystem.controller;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.system.UserInfoDTO;
import org.chenjh.aiqasystem.domain.dto.system.UserTokenDTO;
import org.chenjh.aiqasystem.domain.vo.system.ChangePasswordVO;
import org.chenjh.aiqasystem.domain.vo.system.UpdateUserVO;
import org.chenjh.aiqasystem.domain.vo.system.UserLoginVO;
import org.chenjh.aiqasystem.domain.vo.system.UserRegisterVO;
import org.chenjh.aiqasystem.service.user.AccountService;
import org.springframework.web.bind.annotation.*;

/**
 * @author hjong
 * @date 2025−02−23
 */
@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Resource
    private AccountService accountService;


    /**
     * 登录
     * @param vo 登录信息
     * @return 登录结果
     */
    @PostMapping("/login")
    public Result<UserTokenDTO> login(@Valid @RequestBody UserLoginVO vo) {
        return Result.ok(accountService.login(vo));
    }

    /**
     * 注册
     * @param vo 注册信息
     * @return 注册结果
     */
    @PostMapping()
    public Result<UserInfoDTO> register(@Valid @RequestBody UserRegisterVO vo) {
        return Result.ok(accountService.register(vo));
    }

    /**
     * 修改密码
     * @param vo 密码信息
     * @return 修改结果
     */
    @PostMapping("/change-password")
    public Result<String> changePassword(@Valid @RequestBody ChangePasswordVO vo) {
        return Result.ok(accountService.changePassword(StpUtil.getLoginIdAsString(), vo));
    }

    /**
     * 更新用户信息
     * @param vo 更新信息
     * @return 用户信息
     */
    @PutMapping()
    public Result<String> updateUserInfo(@Valid @RequestBody UpdateUserVO vo) {
        return Result.ok(accountService.updateUserInfo(StpUtil.getLoginIdAsString(), vo));
    }


    /**
     * 获取用户信息
     * @return 用户信息
     */
    @GetMapping("/me")
    public Result<UserInfoDTO> getUserInfo() {
        return Result.ok(accountService.getUserInfo(StpUtil.getLoginIdAsString()));
    }
}
