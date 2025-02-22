package org.chenjh.aiqasystem.service.question;

import org.chenjh.aiqasystem.domain.dto.question.TagGroupDTO;
import org.chenjh.aiqasystem.domain.vo.question.SaveTagVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateTagVO;

import java.util.List;

public interface TagService {

    /**
     * 新增标签
     * @param vo 新增标签信息
     */
    void saveTag(SaveTagVO vo);

    /**
     * 删除标签
     * @param tagId 标签id
     */
    void deleteTag(Long tagId);

    /**
     * 更新标签
     * @param vo 更新标签信息
     */
    void updateTag(UpdateTagVO vo);

    /**
     * 查询标签
     * @return 标签列表
     */
    List<TagGroupDTO> getTagGroup();
}
