/*
 * This file is generated by jOOQ.
 */
package com.nrapendra.jooq.tables;


import com.nrapendra.jooq.AiQaSystem;
import com.nrapendra.jooq.Keys;
import com.nrapendra.jooq.tables.records.OperationLogRecord;

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


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OperationLogTb extends TableImpl<OperationLogRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>ai_qa_system.sys_operation_log</code>
     */
    public static final OperationLogTb SYS_OPERATION_LOG = new OperationLogTb();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OperationLogRecord> getRecordType() {
        return OperationLogRecord.class;
    }

    /**
     * The column <code>ai_qa_system.sys_operation_log.id</code>.
     */
    public final TableField<OperationLogRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>ai_qa_system.sys_operation_log.content</code>. 操作内容
     */
    public final TableField<OperationLogRecord, String> CONTENT = createField(DSL.name("content"), SQLDataType.VARCHAR(255), this, "操作内容");

    /**
     * The column <code>ai_qa_system.sys_operation_log.method_name</code>. 请求方法
     */
    public final TableField<OperationLogRecord, String> METHOD_NAME = createField(DSL.name("method_name"), SQLDataType.VARCHAR(255), this, "请求方法");

    /**
     * The column <code>ai_qa_system.sys_operation_log.request_params</code>.
     * 请求参数
     */
    public final TableField<OperationLogRecord, String> REQUEST_PARAMS = createField(DSL.name("request_params"), SQLDataType.VARCHAR(2000), this, "请求参数");

    /**
     * The column <code>ai_qa_system.sys_operation_log.operator</code>. 操作者
     */
    public final TableField<OperationLogRecord, String> OPERATOR = createField(DSL.name("operator"), SQLDataType.VARCHAR(255), this, "操作者");

    /**
     * The column <code>ai_qa_system.sys_operation_log.operation_time</code>.
     * 操作时间
     */
    public final TableField<OperationLogRecord, LocalDateTime> OPERATION_TIME = createField(DSL.name("operation_time"), SQLDataType.LOCALDATETIME(0), this, "操作时间");

    /**
     * The column <code>ai_qa_system.sys_operation_log.time_taken</code>. 耗时
     */
    public final TableField<OperationLogRecord, Long> TIME_TAKEN = createField(DSL.name("time_taken"), SQLDataType.BIGINT, this, "耗时");

    private OperationLogTb(Name alias, Table<OperationLogRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private OperationLogTb(Name alias, Table<OperationLogRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>ai_qa_system.sys_operation_log</code> table
     * reference
     */
    public OperationLogTb(String alias) {
        this(DSL.name(alias), SYS_OPERATION_LOG);
    }

    /**
     * Create an aliased <code>ai_qa_system.sys_operation_log</code> table
     * reference
     */
    public OperationLogTb(Name alias) {
        this(alias, SYS_OPERATION_LOG);
    }

    /**
     * Create a <code>ai_qa_system.sys_operation_log</code> table reference
     */
    public OperationLogTb() {
        this(DSL.name("sys_operation_log"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : AiQaSystem.AI_QA_SYSTEM;
    }

    @Override
    public Identity<OperationLogRecord, Long> getIdentity() {
        return (Identity<OperationLogRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<OperationLogRecord> getPrimaryKey() {
        return Keys.KEY_SYS_OPERATION_LOG_PRIMARY;
    }

    @Override
    public OperationLogTb as(String alias) {
        return new OperationLogTb(DSL.name(alias), this);
    }

    @Override
    public OperationLogTb as(Name alias) {
        return new OperationLogTb(alias, this);
    }

    @Override
    public OperationLogTb as(Table<?> alias) {
        return new OperationLogTb(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public OperationLogTb rename(String name) {
        return new OperationLogTb(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OperationLogTb rename(Name name) {
        return new OperationLogTb(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public OperationLogTb rename(Table<?> name) {
        return new OperationLogTb(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OperationLogTb where(Condition condition) {
        return new OperationLogTb(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OperationLogTb where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OperationLogTb where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OperationLogTb where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public OperationLogTb where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public OperationLogTb where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public OperationLogTb where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public OperationLogTb where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OperationLogTb whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OperationLogTb whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
