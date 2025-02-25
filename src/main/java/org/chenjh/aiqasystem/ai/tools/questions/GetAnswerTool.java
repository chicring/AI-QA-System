package org.chenjh.aiqasystem.ai.tools.questions;

import org.chenjh.aiqasystem.domain.dto.question.AnswerDTO;
import org.chenjh.aiqasystem.repo.question.AnswerRepository;
import org.springframework.ai.tool.annotation.ToolParam;

import java.util.function.Function;

/**
 * @author hjong
 * @date 2025−02−25
 */
public class GetAnswerTool implements Function<GetAnswerTool.Request, GetAnswerTool.Response> {

    private final AnswerRepository answerRepository;

    public GetAnswerTool(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public record Request(@ToolParam(description = "题目Id") Long questionId) {
    }

    public record Response(AnswerDTO answer) {
    }

    @Override
    public Response apply(Request request) {
        return new Response(answerRepository.findAnswerByQuestionId(request.questionId()));
    }
}