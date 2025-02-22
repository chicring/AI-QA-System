package org.chenjh.aiqasystem.service.system;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.nrapendra.jooq.tables.records.UserRecord;
import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.dto.system.UserInfoDTO;
import org.chenjh.aiqasystem.domain.dto.system.UserTokenDTO;
import org.chenjh.aiqasystem.domain.vo.system.UserLoginVO;
import org.chenjh.aiqasystem.exception.custom.BadRequestException;
import org.chenjh.aiqasystem.exception.custom.ResourceNotFoundException;
import org.chenjh.aiqasystem.repo.system.UserRepository;
import org.chenjh.aiqasystem.repo.system.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserRoleRepository userRoleRepository;


    @Override
    public UserTokenDTO login(UserLoginVO vo) {
        Optional<UserRecord> userRecord = userRepository.findByUsername(vo.getUsername());
        if(userRecord.isEmpty()){
            throw new ResourceNotFoundException("用户不存在");
        }
        if(!SaSecureUtil.sha256(vo.getPassword()).equals(userRecord.get().getPassword())){
            throw new BadRequestException("密码错误");
        }

        StpUtil.login(vo.getUsername());

        return UserTokenDTO.builder()
                .username(vo.getUsername())
                .nickname(userRecord.get().getNickname())
                .token(StpUtil.getTokenValue())
                .build();
    }

    @Override
    public UserInfoDTO getUserInfoByName(String userName) {
        Optional<UserRecord> userRecord = userRepository.findByUsername(userName);
        if(userRecord.isEmpty()){
            throw new ResourceNotFoundException("用户不存在");
        }
        return null;
    }

    @Override
    public void deleteUser(String username) {

    }
}
