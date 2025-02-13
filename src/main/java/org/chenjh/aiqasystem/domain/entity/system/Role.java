package org.chenjh.aiqasystem.domain.entity.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.chenjh.aiqasystem.domain.entity.BaseDO;

import java.time.Instant;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends BaseDO {

    private Long id;               // 角色ID
    private String name;           // 角色名称
    private Integer level;         // 角色级别：0-9，数字越小级别越高
    private Integer type;          // 角色类型：1-内置，2-自定义
    private String remark;         // 备注
}