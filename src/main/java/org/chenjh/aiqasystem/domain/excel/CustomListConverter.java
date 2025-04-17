package org.chenjh.aiqasystem.domain.excel;

import cn.idev.excel.converters.Converter;
import cn.idev.excel.converters.ReadConverterContext;
import cn.idev.excel.enums.CellDataTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjong
 * @date 2025−04−16
 */
@Slf4j
public class CustomListConverter implements Converter<List<Long>> {
    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    // 将
    @Override
    public List<Long> convertToJavaData(ReadConverterContext<?> context) {
        String value = context.getReadCellData().getStringValue();
        log.info("转换值：{}", value);
        if (value == null || value.isEmpty()) {
            return List.of();
        }
        String[] split = value.split(",");
        List<Long> result = new ArrayList<>();
        for (String s : split) {
            try {
                result.add(Long.parseLong(s.trim()));
            } catch (NumberFormatException e) {
                // 处理转换异常
                throw new RuntimeException("转换失败，无法将字符串转换为数字：" + s, e);
            }
        }
        return result;
    }
}
