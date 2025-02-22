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
                    array(select(QA_TAG.TAG_NAME)
                            .from(QA_TAG)
                            .where(QA_TAG.CATEGORY_ID.eq(QA_CATEGORY.ID))
                            .orderBy(QA_TAG.SORT_NUM)
                    ).as("tagNames")
                )
                .from(QA_CATEGORY)
                .fetchInto(TagGroupDTO.class);
    }

}
