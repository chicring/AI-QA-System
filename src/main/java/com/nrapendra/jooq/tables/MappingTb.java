/*
 * This file is generated by jOOQ.
 */
package com.nrapendra.jooq.tables;


import com.nrapendra.jooq.AiQaSystem;
import com.nrapendra.jooq.Keys;
import com.nrapendra.jooq.tables.records.MappingRecord;

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
 * 题目标签关联表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MappingTb extends TableImpl<MappingRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>ai_qa_system.qa_mapping</code>
     */
    public static final MappingTb QA_MAPPING = new MappingTb();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MappingRecord> getRecordType() {
        return MappingRecord.class;
    }

    /**
     * The column <code>ai_qa_system.qa_mapping.id</code>. 主键ID
     */
    public final TableField<MappingRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "主键ID");

    /**
     * The column <code>ai_qa_system.qa_mapping.question_id</code>. 题目ID
     */
    public final TableField<MappingRecord, Long> QUESTION_ID = createField(DSL.name("question_id"), SQLDataType.BIGINT.nullable(false), this, "题目ID");

    /**
     * The column <code>ai_qa_system.qa_mapping.category_id</code>. 分类ID
     */
    public final TableField<MappingRecord, Long> CATEGORY_ID = createField(DSL.name("category_id"), SQLDataType.BIGINT.nullable(false), this, "分类ID");

    /**
     * The column <code>ai_qa_system.qa_mapping.tag_id</code>. 标签ID
     */
    public final TableField<MappingRecord, Long> TAG_ID = createField(DSL.name("tag_id"), SQLDataType.BIGINT.nullable(false), this, "标签ID");

    /**
     * The column <code>ai_qa_system.qa_mapping.create_time</code>. 创建时间
     */
    public final TableField<MappingRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>ai_qa_system.qa_mapping.update_time</code>. 修改时间
     */
    public final TableField<MappingRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "修改时间");

    /**
     * The column <code>ai_qa_system.qa_mapping.creator</code>. 创建者
     */
    public final TableField<MappingRecord, String> CREATOR = createField(DSL.name("creator"), SQLDataType.VARCHAR(255), this, "创建者");

    private MappingTb(Name alias, Table<MappingRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private MappingTb(Name alias, Table<MappingRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment("题目标签关联表"), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>ai_qa_system.qa_mapping</code> table reference
     */
    public MappingTb(String alias) {
        this(DSL.name(alias), QA_MAPPING);
    }

    /**
     * Create an aliased <code>ai_qa_system.qa_mapping</code> table reference
     */
    public MappingTb(Name alias) {
        this(alias, QA_MAPPING);
    }

    /**
     * Create a <code>ai_qa_system.qa_mapping</code> table reference
     */
    public MappingTb() {
        this(DSL.name("qa_mapping"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : AiQaSystem.AI_QA_SYSTEM;
    }

    @Override
    public Identity<MappingRecord, Long> getIdentity() {
        return (Identity<MappingRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<MappingRecord> getPrimaryKey() {
        return Keys.KEY_QA_MAPPING_PRIMARY;
    }

    @Override
    public MappingTb as(String alias) {
        return new MappingTb(DSL.name(alias), this);
    }

    @Override
    public MappingTb as(Name alias) {
        return new MappingTb(alias, this);
    }

    @Override
    public MappingTb as(Table<?> alias) {
        return new MappingTb(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public MappingTb rename(String name) {
        return new MappingTb(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MappingTb rename(Name name) {
        return new MappingTb(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public MappingTb rename(Table<?> name) {
        return new MappingTb(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public MappingTb where(Condition condition) {
        return new MappingTb(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public MappingTb where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public MappingTb where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public MappingTb where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public MappingTb where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public MappingTb where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public MappingTb where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public MappingTb where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public MappingTb whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public MappingTb whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
