package org.chenjh.aiqasystem.ai;

import org.chenjh.aiqasystem.ai.tools.questions.GetAnswerTool;
import org.chenjh.aiqasystem.ai.tools.questions.SearchQuestionTool;
import org.chenjh.aiqasystem.repo.question.AnswerRepository;
import org.chenjh.aiqasystem.repo.question.QuestionRepository;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDateTime;

/**
 * @author hjong
 * @date 2025−02−25
 */
@Configuration(proxyBeanMethods = false)
public class ToolsConfig {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public ToolsConfig(QuestionRepository questionRepository,
                      AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Bean
    public ToolCallback searchQuestion() {
        return FunctionToolCallback
                .builder("searchQuestions", new SearchQuestionTool(questionRepository))
                .description("通过关键词搜索问题")
                .inputType(SearchQuestionTool.Request.class)
                .build();
    }

    @Bean
    public ToolCallback getQuestionAnswer() {
        return FunctionToolCallback
                .builder("getQuestionAnswer", new GetAnswerTool(answerRepository))
                .description("通过题目id获取答案")
                .inputType(GetAnswerTool.Request.class)
                .build();
    }
}