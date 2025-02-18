package org.chenjh.aiqasystem.service.question;

import com.nrapendra.jooq.tables.records.TagRecord;
import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.TagDTO;
import org.chenjh.aiqasystem.domain.vo.question.AddTagVO;
import org.chenjh.aiqasystem.domain.vo.question.TagQueryVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateTagVO;
import org.chenjh.aiqasystem.exception.custom.BadRequestException;
import org.chenjh.aiqasystem.exception.custom.ResourceNotFoundException;
import org.chenjh.aiqasystem.exception.custom.ServerException;
import org.chenjh.aiqasystem.repo.question.TagQuestionRepository;
import org.chenjh.aiqasystem.repo.question.TagRepository;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagServiceImpl implements TagService{

    @Resource
    private TagRepository tagRepository;

    @Resource
    private TagQuestionRepository tagQuestionRepository;

    @Override
    public TagDTO addTag(AddTagVO vo) {
        TagRecord tagRecord = new TagRecord();
        tagRecord.setTagName(vo.getTagName());
        tagRecord.setTagLevel(UByte.valueOf(vo.getTagLevel()));
        tagRecord.setTagSort(UInteger.valueOf(vo.getTagSort()));
        tagRecord.setParentTagId(vo.getParentTagId());
        TagRecord tag = tagRepository.save(tagRecord);
        return TagDTO.builder()
                .tagName(tag.getTagName())
                .tagId(tag.getId())
                .sort(tag.getTagSort().intValue())
                .build();
    }

    @Override
    public void deleteTag(Long tagId) {
        Optional<TagRecord> tagRecord = tagRepository.findById(tagId);

        if(tagRecord.isEmpty()){
            throw new ResourceNotFoundException("标签不存在");
        }

        if(tagRecord.get().getParentTagId().intValue() == 1){
            throw new BadRequestException("一级标签不能删除");
        }

        boolean result = tagRepository.deleteById(tagId);
        boolean result2 = tagQuestionRepository.deleteByTagId(tagId);

        if(!result){
            throw new ServerException("删除失败");
        }
    }

    @Override
    public void updateTag(UpdateTagVO vo) {
        Optional<TagRecord> tagRecord = tagRepository.findById(vo.getTagId());
        if(tagRecord.isEmpty()){
            throw new ServerException("标签不存在");
        }

        TagRecord record = tagRecord.get();
        record.setTagName(vo.getTagName());
        record.setTagLevel(UByte.valueOf(vo.getTagLevel()));
        record.setTagSort(UInteger.valueOf(vo.getTagSort()));
        record.setParentTagId(vo.getParentTagId());

        if(tagRepository.update(record) == 0){
            throw new RuntimeException("更新失败");
        }
    }

    @Override
    public PageResult<TagDTO> getTagList(TagQueryVO vo) {
        return tagRepository.getTagList(vo);
    }
}
