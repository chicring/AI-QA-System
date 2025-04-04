/*
 * This file is generated by jOOQ.
 */
package com.nrapendra.jooq;


import com.nrapendra.jooq.tables.AnswerTb;
import com.nrapendra.jooq.tables.CategoryTb;
import com.nrapendra.jooq.tables.MappingTb;
import com.nrapendra.jooq.tables.NotificationTb;
import com.nrapendra.jooq.tables.OperationLogTb;
import com.nrapendra.jooq.tables.PermissionTb;
import com.nrapendra.jooq.tables.QuestionFavoriteTb;
import com.nrapendra.jooq.tables.QuestionHistoryTb;
import com.nrapendra.jooq.tables.QuestionTb;
import com.nrapendra.jooq.tables.RolePermissionTb;
import com.nrapendra.jooq.tables.RoleTb;
import com.nrapendra.jooq.tables.TagTb;
import com.nrapendra.jooq.tables.UserRoleTb;
import com.nrapendra.jooq.tables.UserTb;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AiQaSystem extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>ai_qa_system</code>
     */
    public static final AiQaSystem AI_QA_SYSTEM = new AiQaSystem();

    /**
     * 题目答案表
     */
    public final AnswerTb QA_ANSWER = AnswerTb.QA_ANSWER;

    /**
     * 题目分类表
     */
    public final CategoryTb QA_CATEGORY = CategoryTb.QA_CATEGORY;

    /**
     * 题目标签关联表
     */
    public final MappingTb QA_MAPPING = MappingTb.QA_MAPPING;

    /**
     * 题目表
     */
    public final QuestionTb QA_QUESTION = QuestionTb.QA_QUESTION;

    /**
     * 题目收藏表
     */
    public final QuestionFavoriteTb QA_QUESTION_FAVORITE = QuestionFavoriteTb.QA_QUESTION_FAVORITE;

    /**
     * 题目历史记录表
     */
    public final QuestionHistoryTb QA_QUESTION_HISTORY = QuestionHistoryTb.QA_QUESTION_HISTORY;

    /**
     * 标签表
     */
    public final TagTb QA_TAG = TagTb.QA_TAG;

    /**
     * The table <code>ai_qa_system.sys_notification</code>.
     */
    public final NotificationTb SYS_NOTIFICATION = NotificationTb.SYS_NOTIFICATION;

    /**
     * The table <code>ai_qa_system.sys_operation_log</code>.
     */
    public final OperationLogTb SYS_OPERATION_LOG = OperationLogTb.SYS_OPERATION_LOG;

    /**
     * 权限表
     */
    public final PermissionTb SYS_PERMISSION = PermissionTb.SYS_PERMISSION;

    /**
     * 角色表
     */
    public final RoleTb SYS_ROLE = RoleTb.SYS_ROLE;

    /**
     * 角色权限关联表
     */
    public final RolePermissionTb SYS_ROLE_PERMISSION = RolePermissionTb.SYS_ROLE_PERMISSION;

    /**
     * 用户表
     */
    public final UserTb SYS_USER = UserTb.SYS_USER;

    /**
     * 用户角色关联表
     */
    public final UserRoleTb SYS_USER_ROLE = UserRoleTb.SYS_USER_ROLE;

    /**
     * No further instances allowed
     */
    private AiQaSystem() {
        super("ai_qa_system", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            AnswerTb.QA_ANSWER,
            CategoryTb.QA_CATEGORY,
            MappingTb.QA_MAPPING,
            QuestionTb.QA_QUESTION,
            QuestionFavoriteTb.QA_QUESTION_FAVORITE,
            QuestionHistoryTb.QA_QUESTION_HISTORY,
            TagTb.QA_TAG,
            NotificationTb.SYS_NOTIFICATION,
            OperationLogTb.SYS_OPERATION_LOG,
            PermissionTb.SYS_PERMISSION,
            RoleTb.SYS_ROLE,
            RolePermissionTb.SYS_ROLE_PERMISSION,
            UserTb.SYS_USER,
            UserRoleTb.SYS_USER_ROLE
        );
    }
}
