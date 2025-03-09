package org.chenjh.aiqasystem.ai.agent;

import org.chenjh.aiqasystem.ai.prompt.Template;
import org.chenjh.aiqasystem.domain.vo.ai.ChatRequest;
import org.chenjh.aiqasystem.domain.vo.ai.Message;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import static org.chenjh.aiqasystem.domain.vo.ai.Message.createMessage;


/**
 * @author hjong
 * @date 2025−02−24
 */
@Component
public class QuestionAgent {
    private final OpenAiChatModel chatModel;
    private final ChatClient chatClient;
    private final ToolCallback searchQuestion;
    private final ToolCallback getQuestionAnswer;


    public QuestionAgent(OpenAiChatModel chatModel, ToolCallback searchQuestion, ToolCallback getQuestionAnswer) {
        this.chatModel = chatModel;
        this.chatClient = ChatClient.builder(chatModel)
                .defaultSystem(Template.AISystemTemplate)
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
        this.searchQuestion = searchQuestion;
        this.getQuestionAnswer = getQuestionAnswer;
    }

    public Flux<Message> chat(ChatRequest request){

        return chatClient
                .prompt()
                .tools(searchQuestion, getQuestionAnswer)
                .advisors(advisor -> advisor.param("chat_memory_conversation_id", request.getConversationId())
                        .param("chat_memory_response_size", 100))
                .user(request.getMessage())
                .stream()
                .chatResponse()
                .map(Message::createMessage);
    }
}
