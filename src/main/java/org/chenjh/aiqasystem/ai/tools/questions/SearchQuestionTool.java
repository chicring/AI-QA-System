package org.chenjh.aiqasystem.ai.tools.questions;
import org.chenjh.aiqasystem.domain.dto.question.QuestionDTO;
import org.chenjh.aiqasystem.repo.question.QuestionRepository;
import org.springframework.ai.tool.annotation.ToolParam;

import java.util.List;
import java.util.function.Function;

/**
 * 根据关键字搜索问题
 * @author hjong
 * @date 2025−02−25
 */
public class SearchQuestionTool implements Function<SearchQuestionTool.Request, SearchQuestionTool.Response> {

    private final QuestionRepository questionRepository;

    public SearchQuestionTool(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public record Request(@ToolParam(description = "题目标题关键词") String q) {
    }

    public record Response(List<QuestionDTO> questions) {
    }

    @Override
    public Response apply(Request request) {
        return new Response(questionRepository.searchByTitle(request.q()));
    }
}
