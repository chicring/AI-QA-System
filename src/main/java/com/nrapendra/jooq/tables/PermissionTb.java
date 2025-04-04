/*
 * This file is generated by jOOQ.
 */
package com.nrapendra.jooq.tables;


import com.nrapendra.jooq.AiQaSystem;
import com.nrapendra.jooq.Keys;
import com.nrapendra.jooq.tables.RolePermissionTb.SysRolePermissionPath;
import com.nrapendra.jooq.tables.records.PermissionRecord;

import java.time.LocalDateTime;
import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
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
 * 权限表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PermissionTb extends TableImpl<PermissionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>ai_qa_system.sys_permission</code>
     */
    public static final PermissionTb SYS_PERMISSION = new PermissionTb();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PermissionRecord> getRecordType() {
        return PermissionRecord.class;
    }

    /**
     * The column <code>ai_qa_system.sys_permission.id</code>. 权限ID
     */
    public final TableField<PermissionRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "权限ID");

    /**
     * The column <code>ai_qa_system.sys_permission.name</code>. 权限名称
     */
    public final TableField<PermissionRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "权限名称");

    /**
     * The column <code>ai_qa_system.sys_permission.scope</code>. 权限范围
     */
    public final TableField<PermissionRecord, String> SCOPE = createField(DSL.name("scope"), SQLDataType.VARCHAR(255), this, "权限范围");

    /**
     * The column <code>ai_qa_system.sys_permission.create_time</code>. 创建时间
     */
    public final TableField<PermissionRecord, LocalDateTime> CREATE_TIME = createField(DSL.name("create_time"), SQLDataType.LOCALDATETIME(0), this, "创建时间");

    /**
     * The column <code>ai_qa_system.sys_permission.update_time</code>. 更新时间
     */
    public final TableField<PermissionRecord, LocalDateTime> UPDATE_TIME = createField(DSL.name("update_time"), SQLDataType.LOCALDATETIME(0), this, "更新时间");

    /**
     * The column <code>ai_qa_system.sys_permission.creator</code>. 创建者
     */
    public final TableField<PermissionRecord, String> CREATOR = createField(DSL.name("creator"), SQLDataType.VARCHAR(255), this, "创建者");

    private PermissionTb(Name alias, Table<PermissionRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PermissionTb(Name alias, Table<PermissionRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment("权限表"), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>ai_qa_system.sys_permission</code> table
     * reference
     */
    public PermissionTb(String alias) {
        this(DSL.name(alias), SYS_PERMISSION);
    }

    /**
     * Create an aliased <code>ai_qa_system.sys_permission</code> table
     * reference
     */
    public PermissionTb(Name alias) {
        this(alias, SYS_PERMISSION);
    }

    /**
     * Create a <code>ai_qa_system.sys_permission</code> table reference
     */
    public PermissionTb() {
        this(DSL.name("sys_permission"), null);
    }

    public <O extends Record> PermissionTb(Table<O> path, ForeignKey<O, PermissionRecord> childPath, InverseForeignKey<O, PermissionRecord> parentPath) {
        super(path, childPath, parentPath, SYS_PERMISSION);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class SysPermissionPath extends PermissionTb implements Path<PermissionRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> SysPermissionPath(Table<O> path, ForeignKey<O, PermissionRecord> childPath, InverseForeignKey<O, PermissionRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private SysPermissionPath(Name alias, Table<PermissionRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public SysPermissionPath as(String alias) {
            return new SysPermissionPath(DSL.name(alias), this);
        }

        @Override
        public SysPermissionPath as(Name alias) {
            return new SysPermissionPath(alias, this);
        }

        @Override
        public SysPermissionPath as(Table<?> alias) {
            return new SysPermissionPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : AiQaSystem.AI_QA_SYSTEM;
    }

    @Override
    public Identity<PermissionRecord, Long> getIdentity() {
        return (Identity<PermissionRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<PermissionRecord> getPrimaryKey() {
        return Keys.KEY_SYS_PERMISSION_PRIMARY;
    }

    private transient SysRolePermissionPath _sysRolePermission;

    /**
     * Get the implicit to-many join path to the
     * <code>ai_qa_system.sys_role_permission</code> table
     */
    public SysRolePermissionPath sysRolePermission() {
        if (_sysRolePermission == null)
            _sysRolePermission = new SysRolePermissionPath(this, null, Keys.SYS_ROLE_PERMISSION_SYS_PERMISSION_FK.getInverseKey());

        return _sysRolePermission;
    }

    @Override
    public PermissionTb as(String alias) {
        return new PermissionTb(DSL.name(alias), this);
    }

    @Override
    public PermissionTb as(Name alias) {
        return new PermissionTb(alias, this);
    }

    @Override
    public PermissionTb as(Table<?> alias) {
        return new PermissionTb(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public PermissionTb rename(String name) {
        return new PermissionTb(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PermissionTb rename(Name name) {
        return new PermissionTb(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public PermissionTb rename(Table<?> name) {
        return new PermissionTb(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PermissionTb where(Condition condition) {
        return new PermissionTb(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PermissionTb where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PermissionTb where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PermissionTb where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PermissionTb where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PermissionTb where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PermissionTb where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PermissionTb where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PermissionTb whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PermissionTb whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
