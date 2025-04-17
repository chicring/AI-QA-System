package org.chenjh.aiqasystem.listener.excel;

import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.read.listener.ReadListener;
import lombok.extern.slf4j.Slf4j;
import org.chenjh.aiqasystem.domain.vo.question.SaveQuestionVO;
import org.chenjh.aiqasystem.service.question.QuestionService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjong
 * @date 2025−03−09
 */
@Slf4j
public class UploadQuestionListener implements ReadListener<SaveQuestionVO> {

    private final QuestionService questionService;


    public UploadQuestionListener(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public void invoke(SaveQuestionVO vo, AnalysisContext analysisContext) {
        questionService.saveQuestion(vo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("解析完成");
    }
}

