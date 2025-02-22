package org.chenjh.aiqasystem.domain.vo.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author hjong
 * @date 2025−02−19
 */
@Data
public class SaveTagVO {

    @Size(min = 1, max = 20, message = "标签名称长度为1-20个字符")
    @NotBlank(message = "标签名称不能为空")
    private String tagName;

    private Long categoryId;

    private Integer sortNum;

}
