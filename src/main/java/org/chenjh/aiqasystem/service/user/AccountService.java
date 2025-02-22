package org.chenjh.aiqasystem.service.user;

import org.chenjh.aiqasystem.domain.dto.system.UserInfoDTO;
import org.chenjh.aiqasystem.domain.dto.system.UserTokenDTO;
import org.chenjh.aiqasystem.domain.vo.system.UserLoginVO;
import org.chenjh.aiqasystem.domain.vo.system.UserRegisterVO;

/**
 * @author hjong
 * @date 2025-02-23
 **/
public interface AccountService {
    /**
     * 用户登录
     * @param vo 账号
     * @return 登录结果
     */
    UserTokenDTO login(UserLoginVO vo);

    /**
     * 用户注册
     * @param vo 注册信息
     * @return 注册结果
     */
    UserInfoDTO register(UserRegisterVO vo);

    /**
     * 修改密码
     * @param account 账号
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     */
    String changePassword(String account, String oldPassword, String newPassword);


    /**
     * 获取用户信息
     * @param account 账号
     * @return 用户信息
     */
    UserInfoDTO getUserInfo(String account);

    /**
     * 更新用户信息
     * @param account 账号
     * @param name 姓名
     * @param email 邮箱
     * @param phone 电话
     * @return 更新结果
     */
    String updateUserInfo(String account, String name, String email, String phone);

}
