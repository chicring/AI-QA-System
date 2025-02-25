/*
 * This file is generated by jOOQ.
 */
package com.nrapendra.jooq;


import com.nrapendra.jooq.tables.AnswerTb;
import com.nrapendra.jooq.tables.CategoryTb;
import com.nrapendra.jooq.tables.MappingTb;
import com.nrapendra.jooq.tables.OperationLogTb;
import com.nrapendra.jooq.tables.PermissionTb;
import com.nrapendra.jooq.tables.QuestionTb;
import com.nrapendra.jooq.tables.RolePermissionTb;
import com.nrapendra.jooq.tables.RoleTb;
import com.nrapendra.jooq.tables.TagTb;
import com.nrapendra.jooq.tables.UserRoleTb;
import com.nrapendra.jooq.tables.UserTb;
import com.nrapendra.jooq.tables.records.AnswerRecord;
import com.nrapendra.jooq.tables.records.CategoryRecord;
import com.nrapendra.jooq.tables.records.MappingRecord;
import com.nrapendra.jooq.tables.records.OperationLogRecord;
import com.nrapendra.jooq.tables.records.PermissionRecord;
import com.nrapendra.jooq.tables.records.QuestionRecord;
import com.nrapendra.jooq.tables.records.RolePermissionRecord;
import com.nrapendra.jooq.tables.records.RoleRecord;
import com.nrapendra.jooq.tables.records.TagRecord;
import com.nrapendra.jooq.tables.records.UserRecord;
import com.nrapendra.jooq.tables.records.UserRoleRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * ai_qa_system.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AnswerRecord> KEY_QA_ANSWER_PRIMARY = Internal.createUniqueKey(AnswerTb.QA_ANSWER, DSL.name("KEY_qa_answer_PRIMARY"), new TableField[] { AnswerTb.QA_ANSWER.ID }, true);
    public static final UniqueKey<CategoryRecord> KEY_QA_CATEGORY_PRIMARY = Internal.createUniqueKey(CategoryTb.QA_CATEGORY, DSL.name("KEY_qa_category_PRIMARY"), new TableField[] { CategoryTb.QA_CATEGORY.ID }, true);
    public static final UniqueKey<MappingRecord> KEY_QA_MAPPING_PRIMARY = Internal.createUniqueKey(MappingTb.QA_MAPPING, DSL.name("KEY_qa_mapping_PRIMARY"), new TableField[] { MappingTb.QA_MAPPING.ID }, true);
    public static final UniqueKey<QuestionRecord> KEY_QA_QUESTION_PRIMARY = Internal.createUniqueKey(QuestionTb.QA_QUESTION, DSL.name("KEY_qa_question_PRIMARY"), new TableField[] { QuestionTb.QA_QUESTION.ID }, true);
    public static final UniqueKey<TagRecord> KEY_QA_TAG_PRIMARY = Internal.createUniqueKey(TagTb.QA_TAG, DSL.name("KEY_qa_tag_PRIMARY"), new TableField[] { TagTb.QA_TAG.ID }, true);
    public static final UniqueKey<OperationLogRecord> KEY_SYS_OPERATION_LOG_PRIMARY = Internal.createUniqueKey(OperationLogTb.SYS_OPERATION_LOG, DSL.name("KEY_sys_operation_log_PRIMARY"), new TableField[] { OperationLogTb.SYS_OPERATION_LOG.ID }, true);
    public static final UniqueKey<PermissionRecord> KEY_SYS_PERMISSION_PRIMARY = Internal.createUniqueKey(PermissionTb.SYS_PERMISSION, DSL.name("KEY_sys_permission_PRIMARY"), new TableField[] { PermissionTb.SYS_PERMISSION.ID }, true);
    public static final UniqueKey<RoleRecord> KEY_SYS_ROLE_PRIMARY = Internal.createUniqueKey(RoleTb.SYS_ROLE, DSL.name("KEY_sys_role_PRIMARY"), new TableField[] { RoleTb.SYS_ROLE.ID }, true);
    public static final UniqueKey<RolePermissionRecord> KEY_SYS_ROLE_PERMISSION_PRIMARY = Internal.createUniqueKey(RolePermissionTb.SYS_ROLE_PERMISSION, DSL.name("KEY_sys_role_permission_PRIMARY"), new TableField[] { RolePermissionTb.SYS_ROLE_PERMISSION.ID }, true);
    public static final UniqueKey<UserRecord> KEY_SYS_USER_PRIMARY = Internal.createUniqueKey(UserTb.SYS_USER, DSL.name("KEY_sys_user_PRIMARY"), new TableField[] { UserTb.SYS_USER.ID }, true);
    public static final UniqueKey<UserRoleRecord> KEY_SYS_USER_ROLE_PRIMARY = Internal.createUniqueKey(UserRoleTb.SYS_USER_ROLE, DSL.name("KEY_sys_user_role_PRIMARY"), new TableField[] { UserRoleTb.SYS_USER_ROLE.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<RolePermissionRecord, PermissionRecord> SYS_ROLE_PERMISSION_SYS_PERMISSION_FK = Internal.createForeignKey(RolePermissionTb.SYS_ROLE_PERMISSION, DSL.name("sys_role_permission_sys_permission_FK"), new TableField[] { RolePermissionTb.SYS_ROLE_PERMISSION.PERMISSION_ID }, Keys.KEY_SYS_PERMISSION_PRIMARY, new TableField[] { PermissionTb.SYS_PERMISSION.ID }, true);
    public static final ForeignKey<RolePermissionRecord, RoleRecord> SYS_ROLE_PERMISSION_SYS_ROLE_FK = Internal.createForeignKey(RolePermissionTb.SYS_ROLE_PERMISSION, DSL.name("sys_role_permission_sys_role_FK"), new TableField[] { RolePermissionTb.SYS_ROLE_PERMISSION.ROLE_ID }, Keys.KEY_SYS_ROLE_PRIMARY, new TableField[] { RoleTb.SYS_ROLE.ID }, true);
}
