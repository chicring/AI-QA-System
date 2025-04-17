package org.chenjh.aiqasystem.domain.vo.ai;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hjong
 * @date 2025−02−25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequest {
    private String message;
    private String conversationId;

    /**
     * 附加文件名，可以通过上传接口拿到
     */
    private String files;

    /**
     * 面试官 根据这个字段来区分不同的面试官
     */
    private String interviewer;
}
