package org.chenjh.aiqasystem.service.system;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.system.admin.UserAdminDTO;

public interface UserService {

    /**
     * 删除用户
     * @param username 用户名
     */
    void deleteUser(String username);



    PageResult<UserAdminDTO> pageForAdmin(int pageNum, int pageSize, String username);

}
