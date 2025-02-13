package org.chenjh.aiqasystem.controller;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.QuestionQueryVO;
import org.chenjh.aiqasystem.domain.vo.QuestionSaveVO;
import org.chenjh.aiqasystem.service.question.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    @PostMapping("/save")
    public Result<QuestionDTO> saveQuestion(@RequestBody QuestionSaveVO questionSaveVO){
        return Result.ok(questionService.saveQuestion(questionSaveVO));
    }

    @GetMapping("/{questionId}")
    public Result<QuestionDTO> getQuestionById(@PathVariable Long questionId){

        return Result.ok(questionService.getQuestionById(questionId));
    }

    @GetMapping("/tag/{tagId}")
    public Result<PageResult<QuestionDTO>> getQuestionByTitle(
            @PathVariable Long tagId,
            QuestionQueryVO questionQueryVO) {

//        questionQueryVO.getTagIds().add(tagId);
        return Result.ok(questionService.getQuestionList(questionQueryVO));
    }

}
