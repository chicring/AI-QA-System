package org.chenjh.aiqasystem.service.question;

import com.nrapendra.jooq.tables.records.QuestionRecord;
import com.nrapendra.jooq.tables.records.TagRecord;
import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.convert.TagConvert;
import org.chenjh.aiqasystem.domain.dto.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.question.QuestionQueryVO;
import org.chenjh.aiqasystem.domain.vo.question.QuestionSaveVO;
import org.chenjh.aiqasystem.exception.custom.ResourceNotFoundException;
import org.chenjh.aiqasystem.exception.custom.ServerException;
import org.chenjh.aiqasystem.repo.question.QuestionRepository;
import org.chenjh.aiqasystem.repo.question.TagQuestionRepository;
import org.chenjh.aiqasystem.repo.question.TagRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.chenjh.aiqasystem.domain.convert.QuestionConvert.convert;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Resource
    private QuestionRepository questionRepository;

    @Resource
    private TagRepository tagRepository;

    @Resource
    private TagQuestionRepository tagQuestionRepository;

    @Override
    public QuestionDTO saveQuestion(QuestionSaveVO question) {
        QuestionRecord record = questionRepository.save(convert(question));
        String[] tags = question.getTags().split(",");
        boolean result = tagQuestionRepository.batchSave(record.getQuestionId(), Arrays.stream(tags).map(Long::parseLong).toArray(Long[]::new));
        if (!result) {
            throw new ServerException("保存标签失败");
        }
        return getQuestionById(record.getQuestionId());
    }

    @Override
    public void deleteQuestion(Long id) {

    }

    @Override
    public QuestionDTO getQuestionById(Long questionId) {
        Optional<QuestionRecord> questionRecord = questionRepository.findById(questionId);
        if (questionRecord.isEmpty()) {
            throw new ResourceNotFoundException("问题不存在");
        }
        List<TagRecord> tagRecord = tagRepository.findByQuestionId(questionId);

        return convert(questionRecord.get(), TagConvert.convert(tagRecord));
    }

    @Override
    public PageResult<QuestionDTO> getQuestionList(QuestionQueryVO question) {
        return questionRepository.getQuestionList(question);
    }
}
