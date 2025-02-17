package org.chenjh.aiqasystem.domain.convert;

import com.nrapendra.jooq.tables.records.QuestionRecord;
import org.chenjh.aiqasystem.domain.dto.QuestionDTO;
import org.chenjh.aiqasystem.domain.dto.TagDTO;
import org.chenjh.aiqasystem.domain.vo.QuestionSaveVO;
import org.jooq.types.UByte;

import java.util.List;

public class QuestionConvert {

    public static QuestionDTO convert(QuestionRecord question, List<TagDTO> tags) {

        return QuestionDTO.builder()
                .id(question.getQuestionId())
                .title(question.getQuestionTitle())
                .solution(question.getQuestionSolution())
                .difficultyLevel(question.getDifficulty().intValue())
                .viewCount(question.getViewCount().intValue())
                .creator(question.getCreator())
                .creatorId(question.getCreatorUserId())
                .tags(tags)
                .build();
    }

    public static QuestionRecord convert(QuestionSaveVO question) {
        QuestionRecord questionRecord = new QuestionRecord();
        questionRecord.setQuestionTitle(question.getTitle());
        questionRecord.setQuestionSolution(question.getSolution());
        questionRecord.setDifficulty(UByte.valueOf(question.getDifficultyLevel()));
        questionRecord.setCreator(question.getCreator());
        questionRecord.setCreatorUserId(question.getCreatorId());
        return questionRecord;
    }

}
