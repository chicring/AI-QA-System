package org.chenjh.aiqasystem.service.question.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.idev.excel.FastExcel;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.question.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.question.QueryQuestionVO;
import org.chenjh.aiqasystem.domain.vo.question.SaveQuestionVO;
import org.chenjh.aiqasystem.exception.custom.ResourceNotFoundException;
import org.chenjh.aiqasystem.exception.custom.ServerException;
import org.chenjh.aiqasystem.listener.events.ViewQuestionEvent;
import org.chenjh.aiqasystem.listener.excel.UploadQuestionListener;
import org.chenjh.aiqasystem.repo.question.AnswerRepository;
import org.chenjh.aiqasystem.repo.question.QAMappingRepository;
import org.chenjh.aiqasystem.repo.question.QuestionRepository;
import org.chenjh.aiqasystem.service.question.QuestionService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionRepository questionRepository;

    @Resource
    private QAMappingRepository qaMappingRepository;

    @Resource
    private AnswerRepository answerRepository;

    @Resource
    private ApplicationEventPublisher publisher;


    @Override
    @Transactional
    public void saveQuestion(SaveQuestionVO question) {
        try {
            Long questionId = questionRepository.save(question);
            answerRepository.save(questionId, question.getAnswers());
            qaMappingRepository.save(questionId, question.getCategoryId(), question.getTagIds());
        } catch (Exception e) {
            log.error("保存问题失败", e);
            throw new ServerException("保存问题失败");
        }
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public QuestionDTO getQuestionById(Long questionId) {
        // 先查询问题是否存在
        QuestionDTO questionDTO = questionRepository.findById(questionId)
                .orElseThrow(() -> new ResourceNotFoundException("问题:" + questionId + " 不存在"));

        publisher.publishEvent(new ViewQuestionEvent(this, questionDTO, StpUtil.getLoginIdAsString()));

        return questionDTO;
    }

    @Override
    public PageResult<QuestionDTO> getQuestionList(QueryQuestionVO question) {
        return questionRepository.findPageResult(question);
    }

    @Override
    public void batchImportQuestion(MultipartFile file) {
        try{
            FastExcel.read(file.getInputStream(), SaveQuestionVO.class,
                            new UploadQuestionListener(this))
                    .sheet()
                    .doRead();
        }catch (IOException e){
            log.error("导入题目失败", e);
            throw new ServerException("导入题目失败");
        }
    }
}
