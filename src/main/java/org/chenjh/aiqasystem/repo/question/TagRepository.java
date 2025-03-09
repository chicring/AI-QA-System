package org.chenjh.aiqasystem.repo.question;


import com.nrapendra.jooq.Tables;
import com.nrapendra.jooq.tables.records.TagRecord;
import org.chenjh.aiqasystem.domain.PageResult;
import org.chenjh.aiqasystem.domain.dto.question.TagGroupDTO;
import org.chenjh.aiqasystem.domain.vo.question.SaveTagVO;
import org.chenjh.aiqasystem.domain.vo.question.TagQueryVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateTagVO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.nrapendra.jooq.tables.CategoryTb.QA_CATEGORY;
import static com.nrapendra.jooq.tables.TagTb.QA_TAG;
import static org.jooq.impl.DSL.*;

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
     * @param vo 标签对象
     * @return Long 标签id
     */
    public Long save(SaveTagVO vo) {
        return dsl.insertInto(Tables.QA_TAG)
                .set(QA_TAG.TAG_NAME, vo.getTagName())
                .set(QA_TAG.CATEGORY_ID, vo.getCategoryId())
                .set(QA_TAG.SORT_NUM, UInteger.valueOf(vo.getSortNum()))
                .returning(QA_TAG.ID)
                .fetchOne()
                .getId();
    }

    /**
     * 更新标签
     * @param vo 标签对象
     * @return boolean
     */
    public boolean update(UpdateTagVO vo) {
        return dsl.update(QA_TAG)
                .set(QA_TAG.TAG_NAME, vo.getTagName())
                .set(QA_TAG.CATEGORY_ID, vo.getCategoryId())
                .set(QA_TAG.SORT_NUM, UInteger.valueOf(vo.getSortNum()))
                .where(QA_TAG.ID.eq(vo.getId()))
                .execute() > 0;
    }

    public List<TagGroupDTO> findGroupByCategory() {
        return dsl.select(
                        QA_CATEGORY.ID,
                        QA_CATEGORY.CATEGORY_NAME,
                        groupConcat(QA_TAG.TAG_NAME)
                                .orderBy(QA_TAG.SORT_NUM)
                                .separator(",")
                                .as("tagNames")
                )
                .from(QA_CATEGORY)
                .leftJoin(QA_TAG)
                .on(QA_TAG.CATEGORY_ID.eq(QA_CATEGORY.ID))
                .groupBy(QA_CATEGORY.ID, QA_CATEGORY.CATEGORY_NAME)
                .fetch(record -> {
                    TagGroupDTO dto = new TagGroupDTO();
                    dto.setCategoryName(record.get(QA_CATEGORY.CATEGORY_NAME));
                    String tags = record.get(2, String.class);
                    dto.setTagNames(tags == null ? List.of() :
                            Arrays.asList(tags.split(",")));
                    return dto;
                });
    }

}
