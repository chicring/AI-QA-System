package org.chenjh.aiqasystem.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.system.UserInfoDTO;
import org.chenjh.aiqasystem.domain.dto.system.UserTokenDTO;
import org.chenjh.aiqasystem.domain.vo.system.UserLoginVO;
import org.chenjh.aiqasystem.domain.vo.system.UserRegisterVO;
import org.chenjh.aiqasystem.service.user.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
