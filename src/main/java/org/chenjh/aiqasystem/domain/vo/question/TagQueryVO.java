package org.chenjh.aiqasystem.domain.vo.question;


import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TagQueryVO {

    private Integer pageNum;

    private Integer pageSize;

    @Size(max = 20, message = "标签名称长度最大20字符")
    private String tagName;

    private Long tagId;

    private Long parentTagId;

    private Integer tagLevel;
}
