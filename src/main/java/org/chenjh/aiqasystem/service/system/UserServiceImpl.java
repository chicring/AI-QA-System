package org.chenjh.aiqasystem.service.system;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.repo.system.UserRepository;
import org.chenjh.aiqasystem.repo.system.UserRoleRepository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserRoleRepository userRoleRepository;

    @Override
    public void deleteUser(String username) {

    }
}
