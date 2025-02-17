package org.chenjh.aiqasystem.service.system;

import org.chenjh.aiqasystem.domain.dto.system.UserInfoDTO;
import org.chenjh.aiqasystem.domain.dto.system.UserTokenDTO;
import org.chenjh.aiqasystem.domain.vo.UserLoginVO;
import org.chenjh.aiqasystem.domain.vo.UserRegisterVO;

public interface UserService {

    /**
     * 用户注册
     * @param vo 用户注册信息
     * @return 用户信息
     */
    UserInfoDTO register(UserRegisterVO vo);

    /**
     * 用户登录
     * @param vo 用户登录信息
     * @return tokenDTO
     */
    UserTokenDTO login(UserLoginVO vo);

    /**
     * 根据用户名获取用户信息
     * @param userName 用户名
     * @return 用户信息
     */
    UserInfoDTO getUserInfoByName(String userName);

    /**
     * 删除用户
     * @param username 用户名
     */
    void deleteUser(String username);

}
