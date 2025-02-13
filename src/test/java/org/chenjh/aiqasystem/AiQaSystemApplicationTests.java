package org.chenjh.aiqasystem;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.repo.system.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiQaSystemApplicationTests {

    @Resource
    UserRepository userRepository;

    @Test
    void contextLoads() {

        System.out.println(userRepository.findALl());
    }

}
