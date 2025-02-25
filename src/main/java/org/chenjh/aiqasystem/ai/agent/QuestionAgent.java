package org.chenjh.aiqasystem.ai.agent;

import org.chenjh.aiqasystem.ai.prompt.Template;
import org.chenjh.aiqasystem.domain.vo.ai.QuestionRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.Objects;

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
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
        this.searchQuestion = searchQuestion;
        this.getQuestionAnswer = getQuestionAnswer;
    }

    public Flux<String> chat(QuestionRequest request){
        PromptTemplate promptTemplate = new PromptTemplate(Template.questionTemplate);
        Prompt prompt = promptTemplate.create(
                Map.of("question", request.getQuestion(),  "message", request.getMessage())
        );


        return chatClient.prompt()
                .tools(searchQuestion, getQuestionAnswer)
                .advisors(advisor -> advisor.param("chat_memory_conversation_id", request.getConversationId())
                        .param("chat_memory_response_size", 100))
                .user(prompt.getContents())
                .stream()
                .content()
                .filter(Objects::nonNull)
                .map(content -> "'" + content);

    }
}
