package org.chenjh.aiqasystem.service.question.impl;

import jakarta.annotation.Resource;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.question.TagDTO;
import org.chenjh.aiqasystem.domain.dto.question.TagGroupDTO;
import org.chenjh.aiqasystem.domain.vo.question.SaveTagVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateTagVO;
import org.chenjh.aiqasystem.repo.question.TagRepository;
import org.chenjh.aiqasystem.service.question.TagService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagRepository tagRepository;

    @Override
    public void saveTag(SaveTagVO vo) {
        tagRepository.save(vo);
    }

    @Override
    public void deleteTag(Long tagId) {
        tagRepository.delete(tagId);
    }

    @Override
    public void updateTag(UpdateTagVO vo) {
        tagRepository.update(vo);
    }

    @Override
    public List<TagGroupDTO> getTagGroup() {
        return tagRepository.findGroupByCategory();
    }

    @Override
    public PageResult<TagDTO> getTagList(Integer pageNum, Integer pageSize, String q) {
        return tagRepository.queryPage(pageNum, pageSize, q);
    }
}
