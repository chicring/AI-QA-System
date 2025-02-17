package org.chenjh.aiqasystem.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hjong
 * @date 2025−01−10
 */
@Getter
@AllArgsConstructor
public enum SystemRoleEnum {

    /**
     * 系统内置角色：管理员角色编号
     */
    ADMIN(1L, "管理员"),
    /**
     * 系统内置角色：普通用户角色编号
     */
    USER(2L, "普通用户");

    private final Long id;

    private final String name;

}
