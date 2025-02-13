package org.chenjh.aiqasystem.common;

import java.time.LocalDateTime;

/**
 * @author hjong
 * @date 2025−01−16
 */
public class CommonUtil {

    /**
     * 生成id 生成规则： 时间戳后位
     * @return Long
     */
    public static Long generateId() {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String idStr = timestamp.substring(timestamp.length() - 6);
        return Long.valueOf(idStr);
    }
}
