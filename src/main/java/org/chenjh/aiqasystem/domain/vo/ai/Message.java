package org.chenjh.aiqasystem.domain.vo.ai;

import lombok.Data;
import org.springframework.ai.chat.model.ChatResponse;

/**
 * @author hjong
 * @date 2025−03−08
 */
@Data
public class Message {

    String id;

    String content;

    /**
     * STOP - 停止
     */
    String finishReason;


    public static Message createMessage(ChatResponse chatResponse){
        Message message = new Message();
        message.setId(chatResponse.getMetadata().getId());
        message.setContent(chatResponse.getResult().getOutput().getText());
        message.setFinishReason(chatResponse.getResult().getMetadata().getFinishReason());
        return message;
    }
}
