package org.chenjh.aiqasystem.service.question;

import com.nrapendra.jooq.tables.records.QuestionRecord;
import com.nrapendra.jooq.tables.records.TagRecord;
import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.convert.TagConvert;
import org.chenjh.aiqasystem.domain.dto.QuestionDTO;
import org.chenjh.aiqasystem.domain.vo.QuestionVO;
import org.chenjh.aiqasystem.repo.question.QuestionRepository;
import org.chenjh.aiqasystem.repo.question.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.chenjh.aiqasystem.domain.convert.QuestionConvert.convert;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Resource
    private QuestionRepository questionRepository;

    @Resource
    private TagRepository tagRepository;

    @Override
    public QuestionDTO saveQuestion(QuestionVO question) {
        return null;
    }

    @Override
    public void deleteQuestion(Long id) {

    }

    @Override
    public QuestionDTO getQuestionById(Long questionId) {
        QuestionRecord questionRecord = questionRepository.findById(questionId).get();
        List<TagRecord> tagRecord = tagRepository.findByQuestionId(questionId);

        return convert(questionRecord, TagConvert.convert(tagRecord));
    }
}
