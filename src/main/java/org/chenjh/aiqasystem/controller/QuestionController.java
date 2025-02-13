package org.chenjh.aiqasystem.controller;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.ResultJson;
import org.chenjh.aiqasystem.domain.dto.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.QuestionVO;
import org.chenjh.aiqasystem.service.question.QuestionService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    @PostMapping("/save")
    public ResultJson<> saveQuestion(@RequestBody QuestionVO questionVO){
        return ResultJson.ok(questionService.saveQuestion(questionVO));
    }

    @GetMapping("/{questionId}")
    public ResultJson<QuestionDTO> getQuestionById(@PathVariable Long questionId){

        return ResultJson.ok(questionService.getQuestionById(questionId));
    }

}
