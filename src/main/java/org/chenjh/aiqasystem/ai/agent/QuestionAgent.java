package org.chenjh.aiqasystem.ai.agent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.opencsv.exceptions.CsvException;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.chenjh.aiqasystem.ai.prompt.Template;
import org.chenjh.aiqasystem.common.FileReader;
import org.chenjh.aiqasystem.domain.vo.ai.ChatRequest;
import org.chenjh.aiqasystem.domain.vo.ai.Message;
import org.chenjh.aiqasystem.exception.custom.BadRequestException;
import org.chenjh.aiqasystem.exception.custom.ServerException;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author hjong
 * @date 2025−02−24
 */
@Slf4j
@Component
public class QuestionAgent {
    private final OpenAiChatModel chatModel;
    private final ChatClient chatClient;
    private final ToolCallback searchQuestion;
    private final ToolCallback getQuestionAnswer;

    private final ObjectMapper objectMapper;
    private final FileReader fileReader;

    private final ConcurrentHashMap<String, HashMap<String, String>> conversationFileMap = new ConcurrentHashMap<>();

    public QuestionAgent(OpenAiChatModel chatModel, ToolCallback searchQuestion, ToolCallback getQuestionAnswer,ObjectMapper objectMapper, FileReader fileReader) {
        this.chatModel = chatModel;
        this.chatClient = ChatClient.builder(chatModel)
                .defaultSystem(Template.AISystemTemplate)
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
        this.searchQuestion = searchQuestion;
        this.getQuestionAnswer = getQuestionAnswer;
        this.objectMapper = objectMapper;
        this.fileReader = fileReader;
    }

    public Flux<Message> chat(ChatRequest request) throws JsonProcessingException {

        String prompt;
        if (StringUtils.isNotBlank(request.getFiles())) {
            String fileContext = getFiles(request.getFiles(), request.getConversationId());
            prompt = getFileBasePrompt(fileContext, request.getMessage());
        } else {
            prompt = request.getMessage();
        }

        return chatClient
                .prompt()
                .tools(searchQuestion, getQuestionAnswer)
                .advisors(advisor -> advisor.param("chat_memory_conversation_id", request.getConversationId())
                        .param("chat_memory_response_size", 100))
                .user(prompt)
                .stream()
                .chatResponse()
                .map(Message::createMessage);
    }

    private String getFiles(String files, String conversationId) throws JsonProcessingException {

        HashMap<String, String> fileHashMap = conversationFileMap.get(conversationId);
        if (fileHashMap == null) {
            return "没有找到文件！";
        }
        List<String> fileNames = List.of(files.split(","));

        StringBuilder content = new StringBuilder();
        for (String fileName : fileNames) {
            content.append("文件名：").append(fileName).append("\n");
            content.append(fileHashMap.get(fileName)).append("\n");
        }
        //获取上传的文章后，清空该对话的文章缓存，该对话的缓存文章将存入对话记忆列表中。
        conversationFileMap.remove(conversationId);
        return content.toString();
    }

    public String handleFileUpload(String conversationId, MultipartFile file){
        if(file.isEmpty()){
            throw new BadRequestException("文件不能为空");
        }
        String contentType = file.getContentType();
        if (contentType == null) {
            throw new BadRequestException("文件类型不支持");
        }
        String originalFilename = file.getOriginalFilename();
        String content;

        try {
            switch (contentType) {
                case "text/plain" -> content = fileReader.readTxtFile(file);
                case "text/csv" -> content = fileReader.readCsvFile(file);
                case "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" -> content = fileReader.readExcelFile(file);
                case "application/vnd.openxmlformats-officedocument.wordprocessingml.document" -> content = fileReader.readDocxFile(file);
                case "application/pdf" -> content = fileReader.readPdfFile(file);
                default -> throw new BadRequestException("不支持的文件类型！");
            }
        } catch (IOException | CsvException e) {
            throw new ServerException("服务器错误！", e);
        }
        log.info("文件内容：{}", content);
        conversationFileMap.putIfAbsent(conversationId, new HashMap<>());
        conversationFileMap.get(conversationId).put(originalFilename, content);
        return originalFilename;
    }

    private String getFileBasePrompt(String files, String question) {

        String userText = """
                请根据以下文件内容回答问题：
                {files}
                问题如下：
                {question}
                """;
        PromptTemplate promptTemplate = new PromptTemplate(userText);
        Prompt prompt = promptTemplate.create(Map.of("files", files, "question", question));
        return prompt.getContents();
    }
}
