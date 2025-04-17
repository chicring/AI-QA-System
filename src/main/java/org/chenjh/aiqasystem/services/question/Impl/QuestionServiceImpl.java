package org.chenjh.aiqasystem.services.question.Impl;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryMethods;
import com.mybatisflex.core.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.chenjh.aiqasystem.domain.dto.question.QuestionDTO;
import org.chenjh.aiqasystem.domain.entity.question.QuestionDO;
import org.chenjh.aiqasystem.domain.vo.question.QueryQuestionVO;
import org.chenjh.aiqasystem.domain.vo.question.QuestionVO;
import org.chenjh.aiqasystem.mapper.question.QuestionMapper;
import org.chenjh.aiqasystem.services.question.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mybatisflex.core.query.QueryMethods.findInSet;

/**
 * @author hjong
 * @date 2025−04−17
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public void savOrUpdateQuestion(QuestionVO question) {
        questionMapper.insertOrUpdate(convertToQuestionDO(question));
    }

    @Override
    public void deleteQuestion(Long id) {
        questionMapper.deleteById(id);
    }

    @Override
    public QuestionDTO getQuestionById(Long id) {
        QuestionDO questionDO = questionMapper.selectOneById(id);
        return convertToQuestionDTO(questionDO);
    }

    @Override
    public Page<QuestionDTO> queryQuestionPage(QueryQuestionVO question) {
        QueryWrapper query = new QueryWrapper();
        query.eq("category_name", question.getCategoryName());
        query.like("question_title", question.getTitle());
        if (CollectionUtils.isNotEmpty(question.getTagNames())) {
            question.getTagNames().forEach(tagName -> {
                if (StringUtils.isNotBlank(tagName)) {
                    query.and("tag_names", findInSet(tagName,"tag_names"));
                }
            });
        }

        return null;
    }

    private QuestionDO convertToQuestionDO(QuestionVO vo){
        QuestionDO questionDO = new QuestionDO();
        questionDO.setId(vo.getId());
        questionDO.setQuestionTitle(vo.getQuestionTitle());
        questionDO.setQuestionTips(vo.getQuestionTips());
        questionDO.setDifficulty(vo.getDifficulty());
        questionDO.setAnswer(vo.getAnswer());
        questionDO.setCategoryName(vo.getCategoryName());
        questionDO.setTagNames(StringUtils.join(vo.getTagNames(), ","));
        questionDO.setViewCount(vo.getViewCount());
        return questionDO;
    }

    private QuestionDTO convertToQuestionDTO(QuestionDO questionDO){
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(questionDO.getId());
        questionDTO.setQuestionTitle(questionDO.getQuestionTitle());
        questionDTO.setQuestionTips(questionDO.getQuestionTips());
        questionDTO.setDifficulty(questionDO.getDifficulty());
        questionDTO.setAnswer(questionDO.getAnswer());
        questionDTO.setCategoryName(questionDO.getCategoryName());
        questionDTO.setTagNames(List.of(StringUtils.split(questionDO.getTagNames(), ",")));
        questionDTO.setViewCount(questionDO.getViewCount());
        questionDTO.setCreateTime(questionDO.getCreateTime());
        return questionDTO;
    }
}
