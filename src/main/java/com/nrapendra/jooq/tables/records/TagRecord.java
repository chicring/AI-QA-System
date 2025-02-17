/*
 * This file is generated by jOOQ.
 */
package com.nrapendra.jooq.tables.records;


import com.nrapendra.jooq.tables.TagTb;

import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;


/**
 * 标签表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TagRecord extends UpdatableRecordImpl<TagRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>ai_qa_system.qa_tag.id</code>. 主键ID
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_tag.id</code>. 主键ID
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>ai_qa_system.qa_tag.tag_id</code>. 标签ID
     */
    public void setTagId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_tag.tag_id</code>. 标签ID
     */
    public Long getTagId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>ai_qa_system.qa_tag.tag_name</code>. 标签名称
     */
    public void setTagName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_tag.tag_name</code>. 标签名称
     */
    public String getTagName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>ai_qa_system.qa_tag.parent_tag_id</code>. 父标签ID
     */
    public void setParentTagId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_tag.parent_tag_id</code>. 父标签ID
     */
    public Long getParentTagId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>ai_qa_system.qa_tag.tag_level</code>. 标签层级 1:一级标签 2:二级标签
     */
    public void setTagLevel(UByte value) {
        set(4, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_tag.tag_level</code>. 标签层级 1:一级标签 2:二级标签
     */
    public UByte getTagLevel() {
        return (UByte) get(4);
    }

    /**
     * Setter for <code>ai_qa_system.qa_tag.tag_sort</code>. 排序号
     */
    public void setTagSort(UInteger value) {
        set(5, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_tag.tag_sort</code>. 排序号
     */
    public UInteger getTagSort() {
        return (UInteger) get(5);
    }

    /**
     * Setter for <code>ai_qa_system.qa_tag.tag_status</code>. 状态 1:正常 0:禁用
     */
    public void setTagStatus(UByte value) {
        set(6, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_tag.tag_status</code>. 状态 1:正常 0:禁用
     */
    public UByte getTagStatus() {
        return (UByte) get(6);
    }

    /**
     * Setter for <code>ai_qa_system.qa_tag.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_tag.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>ai_qa_system.qa_tag.update_time</code>. 修改时间
     */
    public void setUpdateTime(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_tag.update_time</code>. 修改时间
     */
    public LocalDateTime getUpdateTime() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>ai_qa_system.qa_tag.creator</code>. 创建者
     */
    public void setCreator(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_tag.creator</code>. 创建者
     */
    public String getCreator() {
        return (String) get(9);
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
     * Create a detached TagRecord
     */
    public TagRecord() {
        super(TagTb.QA_TAG);
    }

    /**
     * Create a detached, initialised TagRecord
     */
    public TagRecord(Long id, Long tagId, String tagName, Long parentTagId, UByte tagLevel, UInteger tagSort, UByte tagStatus, LocalDateTime createTime, LocalDateTime updateTime, String creator) {
        super(TagTb.QA_TAG);

        setId(id);
        setTagId(tagId);
        setTagName(tagName);
        setParentTagId(parentTagId);
        setTagLevel(tagLevel);
        setTagSort(tagSort);
        setTagStatus(tagStatus);
        setCreateTime(createTime);
        setUpdateTime(updateTime);
        setCreator(creator);
        resetChangedOnNotNull();
    }
}
