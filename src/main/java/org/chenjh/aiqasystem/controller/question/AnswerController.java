package org.chenjh.aiqasystem.controller.question;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.question.AnswerDTO;
import org.chenjh.aiqasystem.service.question.AnswerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjong
 * @date 2025−02−23
 */
@RestController
@RequestMapping("/v1/answer")
public class AnswerController {

    @Resource
    private AnswerService answerService;

    @GetMapping("/{questionId}")
    public Result<AnswerDTO> getAnswerByQuestionId(@PathVariable Long questionId) {
        return Result.ok(answerService.findAnswerByQuestionId(questionId));
    }
}
