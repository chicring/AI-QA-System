package org.chenjh.aiqasystem.domain.vo.question;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.chenjh.aiqasystem.domain.excel.CustomListConverter;

import java.util.List;

/**
 * @author hjong
 * @date 2025−02−20
 */
@Data
public class SaveQuestionVO {

    @ExcelProperty(value = "标题")
    private String questionTitle;

    @ExcelProperty(value = "提示")
    private String questionTips;

    @ExcelProperty(value = "难度 1:简单 2:中等 3:困难")
    private Integer difficulty;

    @ExcelProperty(value = "分类ID")
    private Long categoryId;

    @ExcelProperty(value = "标签ID 逗号分隔", converter = CustomListConverter.class)
    private List<Long> tagIds;

    @ExcelProperty(value = "答案")
    private String answers;
}
