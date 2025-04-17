package org.chenjh.aiqasystem.controller.ai;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.ai.agent.QuestionAgent;
import org.chenjh.aiqasystem.config.OperationLog;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.vo.ai.ChatRequest;
import org.chenjh.aiqasystem.domain.vo.ai.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    public Flux<Message> chatWithQuestion(@RequestBody ChatRequest request) throws JsonProcessingException {
        return questionAgent.chat(request);
    }

    @PostMapping("/upload")
    public Result<String> handleUpload(@RequestParam("file") MultipartFile file,
                                       @RequestParam("conversationId") String conversationId) {
        return Result.ok(questionAgent.handleFileUpload(conversationId, file));
    }
}
