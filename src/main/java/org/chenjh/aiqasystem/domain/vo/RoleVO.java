package org.chenjh.aiqasystem.domain.vo;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RoleVO {
    private Long id;
    @Size(min = 2, max = 12, message = "角色名称长度为 2-12 个字符")
    private String name;
    private Integer level;
    private String remark;
    private Long[] permissions;
}
