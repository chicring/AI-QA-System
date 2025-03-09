package org.chenjh.aiqasystem.listener.excel;

import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.read.listener.ReadListener;
import org.chenjh.aiqasystem.domain.vo.question.SaveQuestionVO;
import org.chenjh.aiqasystem.service.question.QuestionService;

/**
 * @author hjong
 * @date 2025−03−09
 */
public class UploadQuestionListener implements ReadListener<SaveQuestionVO> {

    private final QuestionService questionService;

    public UploadQuestionListener(QuestionService questionService) {
        this.questionService = questionService;
    }



    @Override
    public void invoke(SaveQuestionVO vo, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
