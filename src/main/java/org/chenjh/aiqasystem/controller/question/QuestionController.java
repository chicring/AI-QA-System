package org.chenjh.aiqasystem.controller.question;

import cn.idev.excel.FastExcel;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.Result;
import org.chenjh.aiqasystem.domain.dto.question.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.question.QueryQuestionVO;
import org.chenjh.aiqasystem.domain.vo.question.SaveQuestionVO;
import org.chenjh.aiqasystem.exception.custom.BadRequestException;
import org.chenjh.aiqasystem.service.question.QuestionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;


@RestController
@RequestMapping("/v1/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    /**
     * 保存问题
     * @param  vo 问题
     * @return 保存后的问题
     */
    @PostMapping()
    public Result<?> saveQuestion(@Valid @RequestBody SaveQuestionVO vo){
        questionService.saveQuestion(vo);
        return Result.ok();
    }

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
    @DeleteMapping("/{questionId}")
    public Result<?> deleteQuestion(@PathVariable Long questionId){
        questionService.deleteQuestion(questionId);
        return Result.ok();
    }

    /**
     * 获取问题分页列表
     * @param vo 问题查询条件
     * @return 问题列表
     */
    @PostMapping("/list-question")
    public Result<PageResult<QuestionDTO>> getPageResult(@RequestBody QueryQuestionVO vo){
        return Result.ok(questionService.getQuestionList(vo));
    }

    /**
     * 批量导入题目
     * @param file 题目文件
     * @return 导入结果
     */
    @PostMapping("/import")
    public Result<?> importQuestions(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            throw new BadRequestException("文件不能为空");
        }
        questionService.batchImportQuestion(file);
        return Result.ok();
    }

    /**
     * 下载导入模板
     * @return 导出结果
     */
    @GetMapping("/template")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");

        String fileName = URLEncoder.encode("导入模板", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        FastExcel.write(response.getOutputStream(), SaveQuestionVO.class)
                .sheet("模板")
                .doWrite(new ArrayList<>());
    }
}
