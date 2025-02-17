package org.chenjh.aiqasystem.service.question;

import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.TagDTO;
import org.chenjh.aiqasystem.domain.vo.question.AddTagVO;
import org.chenjh.aiqasystem.domain.vo.question.TagQueryVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateTagVO;

public interface TagService {

    TagDTO addTag(AddTagVO vo);

    void deleteTag(Long tagId);

    void updateTag(UpdateTagVO vo);

    PageResult<TagDTO> getTagList(TagQueryVO vo);
}
