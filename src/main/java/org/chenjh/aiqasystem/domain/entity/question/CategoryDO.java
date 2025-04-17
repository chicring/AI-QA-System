package org.chenjh.aiqasystem.domain.entity.question;

import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.chenjh.aiqasystem.domain.entity.BaseDO;

/**
 * @author hjong
 * @date 2025−04−17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table("qa_category")
public class CategoryDO extends BaseDO {

    private Long id;

    private String categoryName;

    private String description;

    private Integer categoryLevel;

    private Integer sortNum;

    private String imageUrl;

}
