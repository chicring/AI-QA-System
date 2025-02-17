package org.chenjh.aiqasystem.controller.question;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.question.QuestionQueryVO;
import org.chenjh.aiqasystem.domain.vo.question.QuestionSaveVO;
import org.chenjh.aiqasystem.service.question.QuestionService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    /**
     * 保存问题
     * @param questionSaveVO 问题
     * @return 保存后的问题
     */
    @PostMapping("/save")
    public Result<QuestionDTO> saveQuestion(@Valid @RequestBody QuestionSaveVO questionSaveVO){
        return Result.ok(questionService.saveQuestion(questionSaveVO));
    }

    //// TODO: 文件批量导入问题

    /**
     * 根据问题id获取问题
     * @param questionId 问题id
     * @return 问题
     */
    @GetMapping("/{questionId}")
    public Result<QuestionDTO> getQuestionById(@PathVariable Long questionId){

        return Result.ok(questionService.getQuestionById(questionId));
    }

    /**
     * 根据问题id删除问题
     * @param questionId 问题id
     * @return 删除结果
     */
    public Result<?> deleteQuestion(@PathVariable Long questionId){
        questionService.deleteQuestion(questionId);
        return Result.ok();
    }

    /**
     * 根据标签id获取问题列表
     * @param tagId 标签id
     * @return 问题列表
     */
    @GetMapping("/tag/{tagId}")
    public Result<PageResult<QuestionDTO>> getQuestionByTag(
            @PathVariable Long tagId,
            @Valid QuestionQueryVO questionQueryVO) {

//        questionQueryVO.getTagIds().add(tagId);
        return Result.ok(questionService.getQuestionList(questionQueryVO));
    }



}
