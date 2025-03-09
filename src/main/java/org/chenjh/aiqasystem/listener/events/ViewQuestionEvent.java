package org.chenjh.aiqasystem.listener.events;

import lombok.Getter;
import org.chenjh.aiqasystem.domain.dto.question.QuestionDTO;
import org.springframework.context.ApplicationEvent;

/**
 * @author hjong
 * @date 2025−03−08
 */
public class ViewQuestionEvent extends ApplicationEvent {

    @Getter
    private final QuestionDTO question;

    @Getter
    private final String username;

    public ViewQuestionEvent(Object source, QuestionDTO question, String username) {
        super(source);
        this.question = question;
        this.username = username;
    }

}
