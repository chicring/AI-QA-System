package org.chenjh.aiqasystem.controller.ai;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.ai.agent.QuestionAgent;
import org.chenjh.aiqasystem.domain.vo.ai.ChatRequest;
import org.chenjh.aiqasystem.domain.vo.ai.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author hjong
 * @date 2025−02−26
 */
@RestController
@RequestMapping("/v1/chat")
public class ChatController {

    @Resource
    private QuestionAgent questionAgent;

    @PostMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> chatWithQuestion(@RequestBody ChatRequest request) {
        return questionAgent.chat(request);
    }

    @PostMapping
    public Flux<Message> chat(@RequestBody ChatRequest request) {
        return questionAgent.chat(request);
    }
}
