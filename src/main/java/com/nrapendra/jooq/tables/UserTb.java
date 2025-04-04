/*
 * This file is generated by jOOQ.
 */
package com.nrapendra.jooq.tables;


import com.nrapendra.jooq.AiQaSystem;
import com.nrapendra.jooq.Keys;
import com.nrapendra.jooq.tables.records.UserRecord;

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
 * 用户表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserTb extends TableImpl<UserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>ai_qa_system.sys_user</code>
     */
    public static final UserTb SYS_USER = new UserTb();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    /**
     * The column <code>ai_qa_system.sys_user.id</code>. 主键ID
     */
    public final TableField<UserRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "主键ID");

    /**
     * The column <code>ai_qa_system.sys_user.username</code>. 用户名
     */
    public final TableField<UserRecord, String> USERNAME = createField(DSL.name("username"), SQLDataType.VARCHAR(36).nullable(false), this, "用户名");

    /**
     * The column <code>ai_qa_system.sys_user.password</code>. 密码
     */
    public final TableField<UserRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.VARCHAR(255), this, "密码");

    /**
     * The column <code>ai_qa_system.sys_user.nickname</code>. 昵称
     */
    public final TableField<UserRecord, String> NICKNAME = createField(DSL.name("nickname"), SQLDataType.VARCHAR(255), this, "昵称");

    /**
     * The column <code>ai_qa_system.sys_user.email</code>. 邮箱
     */
    public final TableField<UserRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR(255), this, "邮箱");

    /**
     * The column <code>ai_qa_system.sys_user.mobile</code>. 手机号
     */
    public final TableField<UserRecord, String> MOBILE = createField(DSL.name("mobile"), SQLDataType.VARCHAR(255), this, "手机号");

    /**
     * The column <code>ai_qa_system.sys_user.sex</code>. 性别：1-男性，2-女性
     */
    public final TableField<UserRecord, Integer> SEX = createField(DSL.name("sex"), SQLDataType.INTEGER, this, "性别：1-男性，2-女性");

    /**
     * The column <code>ai_qa_system.sys_user.avatar</code>. 头像（Base64）
     */
    public final TableField<UserRecord, String> AVATAR = createField(DSL.name("avatar"), SQLDataType.CLOB, this, "头像（Base64）");

    /**
     * The column <code>ai_qa_system.sys_user.enabled</code>. 是否启用：1-启用，0-禁用
     */
    public final TableField<UserRecord, Boolean> ENABLED = createField(DSL.name("enabled"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.inline("1", SQLDataType.BOOLEAN)), this, "是否启用：1-启用，0-禁用");

    /**
     * The column <code>ai_qa_system.sys_user.login_ip</code>. 最近登录IP
     */
    public final TableField<UserRecord, String> LOGIN_IP = createField(DSL.name("login_ip"), SQLDataType.VARCHAR(255), this, "最近登录IP");

    /**
     * The column <code>ai_qa_system.sys_user.login_date</code>. 最近登录时间
     */
    public final TableField<UserRecord, LocalDateTime> LOGIN_DATE = createField(DSL.name("login_date"), SQLDataType.LOCALDATETIME(6), this, "最近登录时间");

    /**
     * The column <code>ai_qa_system.sys_user.create_time</code>. 创建时间
     */
    public final TableField<UserRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(0), this, "创建时间");

    /**
     * The column <code>ai_qa_system.sys_user.update_time</code>. 更新时间
     */
    public final TableField<UserRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(0), this, "更新时间");

    /**
     * The column <code>ai_qa_system.sys_user.creator</code>. 创建者
     */
    public final TableField<UserRecord, String> CREATOR = createField(DSL.name("creator"), SQLDataType.VARCHAR(255), this, "创建者");

    private UserTb(Name alias, Table<UserRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private UserTb(Name alias, Table<UserRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment("用户表"), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>ai_qa_system.sys_user</code> table reference
     */
    public UserTb(String alias) {
        this(DSL.name(alias), SYS_USER);
    }

    /**
     * Create an aliased <code>ai_qa_system.sys_user</code> table reference
     */
    public UserTb(Name alias) {
        this(alias, SYS_USER);
    }

    /**
     * Create a <code>ai_qa_system.sys_user</code> table reference
     */
    public UserTb() {
        this(DSL.name("sys_user"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : AiQaSystem.AI_QA_SYSTEM;
    }

    @Override
    public Identity<UserRecord, Long> getIdentity() {
        return (Identity<UserRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<UserRecord> getPrimaryKey() {
        return Keys.KEY_SYS_USER_PRIMARY;
    }

    @Override
    public UserTb as(String alias) {
        return new UserTb(DSL.name(alias), this);
    }

    @Override
    public UserTb as(Name alias) {
        return new UserTb(alias, this);
    }

    @Override
    public UserTb as(Table<?> alias) {
        return new UserTb(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTb rename(String name) {
        return new UserTb(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTb rename(Name name) {
        return new UserTb(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserTb rename(Table<?> name) {
        return new UserTb(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UserTb where(Condition condition) {
        return new UserTb(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UserTb where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UserTb where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UserTb where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public UserTb where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public UserTb where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public UserTb where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public UserTb where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UserTb whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public UserTb whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
