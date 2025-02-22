package org.chenjh.aiqasystem.repo.question;

import org.chenjh.aiqasystem.domain.dto.question.CategoryDTO;
import org.chenjh.aiqasystem.domain.vo.question.SaveCategoryVO;
import org.chenjh.aiqasystem.domain.vo.question.UpdateCategoryVO;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.nrapendra.jooq.tables.CategoryTb.QA_CATEGORY;
import static com.nrapendra.jooq.tables.MappingTb.QA_MAPPING;

import static org.jooq.impl.DSL.multiset;

/**
 * @author hjong
 * @date 2025−02−19
 */
@Repository
public class CategoryRepository {

    private final DSLContext dsl;

    public CategoryRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Optional<CategoryDTO> findById(long categoryId) {
        CategoryDTO categoryDTO = dsl
                .select(
                        QA_CATEGORY.ID,
                        QA_CATEGORY.CATEGORY_NAME,
                        QA_CATEGORY.CATEGORY_LEVEL,
                        QA_CATEGORY.IMAGE_URL,
                        QA_CATEGORY.DESCRIPTION,
                        QA_CATEGORY.PARENT_CATEGORY_ID,
                        QA_CATEGORY.SORT_NUM,
                        multiset(
                                dsl.selectCount()
                                        .from(QA_MAPPING)
                                        .where(QA_MAPPING.CATEGORY_ID.eq(QA_CATEGORY.ID))
                        ).as("questionCount")

                )
                .from(QA_CATEGORY)
                .where(QA_CATEGORY.ID.eq(categoryId))
                .fetchOneInto(CategoryDTO.class);
        return Optional.ofNullable(categoryDTO);
    }

    public List<CategoryDTO> findAll() {
        return dsl
                .select(
                        QA_CATEGORY.ID,
                        QA_CATEGORY.CATEGORY_NAME,
                        QA_CATEGORY.CATEGORY_LEVEL,
                        QA_CATEGORY.IMAGE_URL,
                        QA_CATEGORY.DESCRIPTION,
                        QA_CATEGORY.PARENT_CATEGORY_ID,
                        QA_CATEGORY.SORT_NUM,
                        multiset(
                                dsl.selectCount()
                                        .from(QA_MAPPING)
                                        .where(QA_MAPPING.CATEGORY_ID.eq(QA_CATEGORY.ID))
                        ).as("questionCount")
                )
                .from(QA_CATEGORY)
                .orderBy(QA_CATEGORY.SORT_NUM.asc())
                .fetchInto(CategoryDTO.class);
    }

    public Long save(SaveCategoryVO vo) {
        return dsl
                .insertInto(QA_CATEGORY)
                .set(QA_CATEGORY.CATEGORY_NAME, vo.getCategoryName())
                .set(QA_CATEGORY.CATEGORY_LEVEL, UInteger.valueOf(vo.getCategoryLevel()))
                .set(QA_CATEGORY.IMAGE_URL, vo.getImageUrl())
                .set(QA_CATEGORY.DESCRIPTION, vo.getDescription())
                .set(QA_CATEGORY.PARENT_CATEGORY_ID, vo.getParentCategoryId())
                .set(QA_CATEGORY.SORT_NUM, UInteger.valueOf(vo.getSortNum()))
                .returning(QA_CATEGORY.ID)
                .fetchOne().getId();
    }

    public boolean update(UpdateCategoryVO vo) {
        return dsl
                .update(QA_CATEGORY)
                .set(QA_CATEGORY.CATEGORY_NAME, vo.getCategoryName())
                .set(QA_CATEGORY.CATEGORY_LEVEL, UInteger.valueOf(vo.getCategoryLevel()))
                .set(QA_CATEGORY.IMAGE_URL, vo.getImageUrl())
                .set(QA_CATEGORY.DESCRIPTION, vo.getDescription())
                .set(QA_CATEGORY.PARENT_CATEGORY_ID, vo.getParentCategoryId())
                .set(QA_CATEGORY.SORT_NUM, UInteger.valueOf(vo.getSortNum()))
                .where(QA_CATEGORY.ID.eq(vo.getId()))
                .execute() == 1;
    }
}
