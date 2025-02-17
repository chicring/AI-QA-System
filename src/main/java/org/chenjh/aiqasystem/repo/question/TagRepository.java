package org.chenjh.aiqasystem.repo.question;


import com.nrapendra.jooq.Tables;
import com.nrapendra.jooq.tables.records.TagRecord;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.TagDTO;
import org.chenjh.aiqasystem.domain.vo.question.TagQueryVO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UByte;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.nrapendra.jooq.tables.TagTb.QA_TAG;
import static org.jooq.impl.DSL.concat;

/**
 * @author hjong
 * @date 2025-01-09
 **/
@Repository
public class TagRepository {

    private final DSLContext dsl;

    public TagRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    /**
     * 保存标签
     * @param tablePojo 标签对象
     * @return TagRecord
     */
    public TagRecord save(TagRecord tablePojo) {
        TagRecord tagRecord = dsl.newRecord(Tables.QA_TAG,tablePojo);
        tagRecord.store();
        return tagRecord;
    }

    /**
     * 更新标签
     * @param record 标签对象
     * @return TagRecord
     */
    public int update(TagRecord record) {
        TagRecord tagRecord = dsl.newRecord(Tables.QA_TAG,record);
        return tagRecord.update(Tables.QA_TAG.TAG_ID.eq(record.getTagId()));
    }

    /**
     * 根据标签ID查询标签
     * @param tagId 标签ID
     * @return TagRecord
     */
    public Optional<TagRecord> findById(long tagId) {
        return dsl.selectFrom(Tables.QA_TAG)
                .where(Tables.QA_TAG.TAG_ID.eq(tagId))
                .fetchOptional();
    }

    public List<TagRecord> findByQuestionId(Long questionId) {
        return dsl.select()
                .from(Tables.QA_TAG)
                .leftJoin(Tables.QA_QUESTION_TAG).on(Tables.QA_TAG.TAG_ID.eq(Tables.QA_QUESTION_TAG.TAG_ID))
                .where(Tables.QA_QUESTION_TAG.QUESTION_ID.eq(questionId))
                .fetch()
                .into(TagRecord.class);
    }

    /**
     * 删除标签
     * @param tagId 标签ID
     * @return boolean
     */
    public boolean deleteById(long tagId) {
        return dsl.delete(Tables.QA_TAG)
                .where(Tables.QA_TAG.TAG_ID.eq(tagId))
                .execute() == 1;
    }

    public PageResult<TagDTO> getTagList(TagQueryVO vo) {
        Long total = dsl.selectCount()
                .from(Tables.QA_TAG)
                .where((vo.getTagName() == null || vo.getTagName().isEmpty()) ?
                        QA_TAG.TAG_NAME.like(concat("%" +vo.getTagName() + "%")) :  DSL.noCondition()
                )
                .and(vo.getTagId() == null ? DSL.noCondition() : QA_TAG.TAG_ID.eq(vo.getTagId()))
                .and(vo.getTagLevel() == null ? DSL.noCondition() : QA_TAG.TAG_LEVEL.eq(UByte.valueOf(vo.getTagLevel())))
                .and(vo.getParentTagId()== null ? DSL.noCondition() : QA_TAG.PARENT_TAG_ID.eq(vo.getParentTagId()))
                .fetchOneInto(Long.class);

        List<TagDTO> tagList = dsl.selectFrom(Tables.QA_TAG)
                .where((vo.getTagName() == null || vo.getTagName().isEmpty()) ?
                         DSL.noCondition() : QA_TAG.TAG_NAME.like(concat("%" +vo.getTagName() + "%"))
                )
                .and(vo.getTagId() == null ? DSL.noCondition() : QA_TAG.TAG_ID.eq(vo.getTagId()))
                .and(vo.getTagLevel() == null ? DSL.noCondition() : QA_TAG.TAG_LEVEL.eq(UByte.valueOf(vo.getTagLevel())))
                .and(vo.getParentTagId()== null ? DSL.noCondition() : QA_TAG.PARENT_TAG_ID.eq(vo.getParentTagId()))
                .orderBy(Tables.QA_TAG.TAG_ID.desc())
                .limit((vo.getPageNum() - 1) * vo.getPageSize(), vo.getPageSize())
                .fetch( r -> TagDTO.builder()
                        .tagId(r.getTagId())
                        .tagName(r.getTagName())
                        .parentTagId(r.getParentTagId() == null ? null : r.getParentTagId().intValue())
                        .sort(r.getTagSort().intValue())
                        .build()
                );
        return PageResult.<TagDTO>builder()
                .page(vo.getPageNum())
                .rows(vo.getPageSize())
                .total(total)
                .data(tagList)
                .build();
    }
}
