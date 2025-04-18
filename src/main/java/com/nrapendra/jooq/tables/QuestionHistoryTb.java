/*
 * This file is generated by jOOQ.
 */
package com.nrapendra.jooq.tables;


import com.nrapendra.jooq.AiQaSystem;
import com.nrapendra.jooq.Keys;
import com.nrapendra.jooq.tables.records.QuestionHistoryRecord;

import java.time.LocalDateTime;
import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;


/**
 * 题目历史记录表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class QuestionHistoryTb extends TableImpl<QuestionHistoryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>ai_qa_system.qa_question_history</code>
     */
    public static final QuestionHistoryTb QA_QUESTION_HISTORY = new QuestionHistoryTb();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QuestionHistoryRecord> getRecordType() {
        return QuestionHistoryRecord.class;
    }

    /**
     * The column <code>ai_qa_system.qa_question_history.id</code>. 主键ID
     */
    public final TableField<QuestionHistoryRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "主键ID");

    /**
     * The column <code>ai_qa_system.qa_question_history.username</code>. 用户名
     */
    public final TableField<QuestionHistoryRecord, String> USERNAME = createField(DSL.name("username"), SQLDataType.VARCHAR(36).nullable(false), this, "用户名");

    /**
     * The column <code>ai_qa_system.qa_question_history.question_id</code>.
     * 题目ID
     */
    public final TableField<QuestionHistoryRecord, Long> QUESTION_ID = createField(DSL.name("question_id"), SQLDataType.BIGINT.nullable(false), this, "题目ID");

    /**
     * The column <code>ai_qa_system.qa_question_history.status</code>. 状态 1:看过
     * 2:已掌握 3:待复习
     */
    public final TableField<QuestionHistoryRecord, Integer> STATUS = createField(DSL.name("status"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("1", SQLDataType.INTEGER)), this, "状态 1:看过 2:已掌握 3:待复习");

    /**
     * The column <code>ai_qa_system.qa_question_history.view_count</code>. 浏览次数
     */
    public final TableField<QuestionHistoryRecord, UInteger> VIEW_COUNT = createField(DSL.name("view_count"), SQLDataType.INTEGERUNSIGNED.nullable(false).defaultValue(DSL.inline("1", SQLDataType.INTEGERUNSIGNED)), this, "浏览次数");

    /**
     * The column <code>ai_qa_system.qa_question_history.last_view_time</code>.
     * 最近一次查看时间
     */
    public final TableField<QuestionHistoryRecord, LocalDateTime> LAST_VIEW_TIME = createField(DSL.name("last_view_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "最近一次查看时间");

    /**
     * The column <code>ai_qa_system.qa_question_history.create_time</code>.
     * 创建时间
     */
    public final TableField<QuestionHistoryRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>ai_qa_system.qa_question_history.update_time</code>.
     * 修改时间
     */
    public final TableField<QuestionHistoryRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "修改时间");

    /**
     * The column <code>ai_qa_system.qa_question_history.is_deleted</code>. 是否删除
     * 0:未删除 1:已删除
     */
    public final TableField<QuestionHistoryRecord, Boolean> IS_DELETED = createField(DSL.name("is_deleted"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.inline("0", SQLDataType.BOOLEAN)), this, "是否删除 0:未删除 1:已删除");

    private QuestionHistoryTb(Name alias, Table<QuestionHistoryRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private QuestionHistoryTb(Name alias, Table<QuestionHistoryRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment("题目历史记录表"), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>ai_qa_system.qa_question_history</code> table
     * reference
     */
    public QuestionHistoryTb(String alias) {
        this(DSL.name(alias), QA_QUESTION_HISTORY);
    }

    /**
     * Create an aliased <code>ai_qa_system.qa_question_history</code> table
     * reference
     */
    public QuestionHistoryTb(Name alias) {
        this(alias, QA_QUESTION_HISTORY);
    }

    /**
     * Create a <code>ai_qa_system.qa_question_history</code> table reference
     */
    public QuestionHistoryTb() {
        this(DSL.name("qa_question_history"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : AiQaSystem.AI_QA_SYSTEM;
    }

    @Override
    public Identity<QuestionHistoryRecord, Long> getIdentity() {
        return (Identity<QuestionHistoryRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<QuestionHistoryRecord> getPrimaryKey() {
        return Keys.KEY_QA_QUESTION_HISTORY_PRIMARY;
    }

    @Override
    public QuestionHistoryTb as(String alias) {
        return new QuestionHistoryTb(DSL.name(alias), this);
    }

    @Override
    public QuestionHistoryTb as(Name alias) {
        return new QuestionHistoryTb(alias, this);
    }

    @Override
    public QuestionHistoryTb as(Table<?> alias) {
        return new QuestionHistoryTb(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public QuestionHistoryTb rename(String name) {
        return new QuestionHistoryTb(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public QuestionHistoryTb rename(Name name) {
        return new QuestionHistoryTb(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public QuestionHistoryTb rename(Table<?> name) {
        return new QuestionHistoryTb(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public QuestionHistoryTb where(Condition condition) {
        return new QuestionHistoryTb(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public QuestionHistoryTb where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public QuestionHistoryTb where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public QuestionHistoryTb where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public QuestionHistoryTb where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public QuestionHistoryTb where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public QuestionHistoryTb where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public QuestionHistoryTb where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public QuestionHistoryTb whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public QuestionHistoryTb whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
