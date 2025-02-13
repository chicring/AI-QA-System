/*
 * This file is generated by jOOQ.
 */
package com.nrapendra.jooq.tables.records;


import com.nrapendra.jooq.tables.PermissionTb;

import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 权限表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PermissionRecord extends UpdatableRecordImpl<PermissionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>ai_qa_system.sys_permission.id</code>. 权限ID
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>ai_qa_system.sys_permission.id</code>. 权限ID
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>ai_qa_system.sys_permission.name</code>. 权限名称
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>ai_qa_system.sys_permission.name</code>. 权限名称
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>ai_qa_system.sys_permission.scope</code>. 权限范围
     */
    public void setScope(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>ai_qa_system.sys_permission.scope</code>. 权限范围
     */
    public String getScope() {
        return (String) get(2);
    }

    /**
     * Setter for <code>ai_qa_system.sys_permission.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>ai_qa_system.sys_permission.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>ai_qa_system.sys_permission.update_time</code>. 更新时间
     */
    public void setUpdateTime(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>ai_qa_system.sys_permission.update_time</code>. 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>ai_qa_system.sys_permission.creator</code>. 创建者
     */
    public void setCreator(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>ai_qa_system.sys_permission.creator</code>. 创建者
     */
    public String getCreator() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PermissionRecord
     */
    public PermissionRecord() {
        super(PermissionTb.SYS_PERMISSION);
    }

    /**
     * Create a detached, initialised PermissionRecord
     */
    public PermissionRecord(Long id, String name, String scope, LocalDateTime createTime, LocalDateTime updateTime, String creator) {
        super(PermissionTb.SYS_PERMISSION);

        setId(id);
        setName(name);
        setScope(scope);
        setCreateTime(createTime);
        setUpdateTime(updateTime);
        setCreator(creator);
        resetChangedOnNotNull();
    }
}
