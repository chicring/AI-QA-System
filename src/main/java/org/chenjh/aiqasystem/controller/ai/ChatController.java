package org.chenjh.aiqasystem.controller.ai;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.ai.agent.QuestionAgent;
import org.chenjh.aiqasystem.domain.vo.ai.QuestionRequest;
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

    @PostMapping(value = "/stream-question", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> chatWithQuestion(@RequestBody QuestionRequest request) {
        return questionAgent.chat(request);
    }
}
