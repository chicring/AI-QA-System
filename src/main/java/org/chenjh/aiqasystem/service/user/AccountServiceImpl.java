package org.chenjh.aiqasystem.service.user;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.nrapendra.jooq.tables.records.UserRecord;
import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.common.SystemRoleEnum;
import org.chenjh.aiqasystem.domain.dto.system.RoleDTO;
import org.chenjh.aiqasystem.domain.dto.system.UserInfoDTO;
import org.chenjh.aiqasystem.domain.dto.system.UserTokenDTO;
import org.chenjh.aiqasystem.domain.vo.system.ChangePasswordVO;
import org.chenjh.aiqasystem.domain.vo.system.UpdateUserVO;
import org.chenjh.aiqasystem.domain.vo.system.UserLoginVO;
import org.chenjh.aiqasystem.domain.vo.system.UserRegisterVO;
import org.chenjh.aiqasystem.exception.custom.BadRequestException;
import org.chenjh.aiqasystem.exception.custom.ResourceNotFoundException;
import org.chenjh.aiqasystem.exception.custom.ServerException;
import org.chenjh.aiqasystem.repo.system.UserRepository;
import org.chenjh.aiqasystem.repo.system.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author hjong
 * @date 2025−02−23
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserRoleRepository userRoleRepository;


    @Override
    public UserTokenDTO login(UserLoginVO vo) {
        UserRecord userRecord = userRepository.findUser(vo.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("用户不存在"));

        if(!SaSecureUtil.sha256(vo.getPassword()).equals(userRecord.getPassword())){
            throw new BadRequestException("密码错误");
        }

        StpUtil.login(vo.getUsername());

        return UserTokenDTO.builder()
                .username(vo.getUsername())
                .nickname(userRecord.getNickname())
                .token(StpUtil.getTokenValue())
                .build();
    }

    @Override
    public UserInfoDTO register(UserRegisterVO vo) {

        userRepository.findByUsername(vo.getUsername()).ifPresent(user -> {
            throw new BadRequestException("用户名已存在");
        });

        vo.setPassword(SaSecureUtil.sha256(vo.getPassword()));
        userRepository.save(vo);
        userRoleRepository.save(vo.getUsername(), SystemRoleEnum.USER.getId());

        RoleDTO roleVO = new RoleDTO();
        roleVO.setName(SystemRoleEnum.USER.getName());
        roleVO.setId(SystemRoleEnum.USER.getId());

        return UserInfoDTO.builder()
                .username(vo.getUsername())
                .nickname(vo.getNickname())
                .email(vo.getEmail())
                .mobile(vo.getMobile())
                .sex(vo.getSex())
                .roles(Set.of(roleVO))
                .build();
    }

    @Override
    public String changePassword(String account, ChangePasswordVO vo) {
        if(vo.getOldPassword().equals(vo.getNewPassword())){
            throw new BadRequestException("新旧密码不能相同");
        }
        if(userRepository.changePassword(account, vo)){
            return "修改成功";
        }
        throw new ServerException("修改失败");
    }


    @Override
    public UserInfoDTO getUserInfo(String account) {
        return userRepository.findByUsername(account)
                .orElseThrow(() -> new ResourceNotFoundException("用户不存在"));
    }

    @Override
    public String updateUserInfo(String account, UpdateUserVO vo) {
        if(userRepository.updateUserInfo(account, vo)){
            return "更新成功";
        }
        throw new ServerException("更新失败");
    }
}
