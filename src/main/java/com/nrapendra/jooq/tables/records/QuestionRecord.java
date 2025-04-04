/*
 * This file is generated by jOOQ.
 */
package com.nrapendra.jooq.tables.records;


import com.nrapendra.jooq.tables.QuestionTb;

import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UByte;
import org.jooq.types.UInteger;


/**
 * 题目表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class QuestionRecord extends UpdatableRecordImpl<QuestionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>ai_qa_system.qa_question.id</code>. 主键ID
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_question.id</code>. 主键ID
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>ai_qa_system.qa_question.question_id</code>. 题目ID
     */
    public void setQuestionId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_question.question_id</code>. 题目ID
     */
    public Long getQuestionId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>ai_qa_system.qa_question.question_title</code>. 题目标题
     */
    public void setQuestionTitle(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_question.question_title</code>. 题目标题
     */
    public String getQuestionTitle() {
        return (String) get(2);
    }

    /**
     * Setter for <code>ai_qa_system.qa_question.question_tips</code>. 题目提示
     */
    public void setQuestionTips(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_question.question_tips</code>. 题目提示
     */
    public String getQuestionTips() {
        return (String) get(3);
    }

    /**
     * Setter for <code>ai_qa_system.qa_question.difficulty</code>. 难度等级 1:简单
     * 2:中等 3:困难
     */
    public void setDifficulty(UInteger value) {
        set(4, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_question.difficulty</code>. 难度等级 1:简单
     * 2:中等 3:困难
     */
    public UInteger getDifficulty() {
        return (UInteger) get(4);
    }

    /**
     * Setter for <code>ai_qa_system.qa_question.view_count</code>. 浏览次数
     */
    public void setViewCount(UInteger value) {
        set(5, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_question.view_count</code>. 浏览次数
     */
    public UInteger getViewCount() {
        return (UInteger) get(5);
    }

    /**
     * Setter for <code>ai_qa_system.qa_question.question_status</code>. 状态 1:正常
     * 0:禁用
     */
    public void setQuestionStatus(UByte value) {
        set(6, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_question.question_status</code>. 状态 1:正常
     * 0:禁用
     */
    public UByte getQuestionStatus() {
        return (UByte) get(6);
    }

    /**
     * Setter for <code>ai_qa_system.qa_question.create_time</code>. 创建时间
     */
    public void setCreateTime(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_question.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>ai_qa_system.qa_question.update_time</code>. 修改时间
     */
    public void setUpdateTime(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_question.update_time</code>. 修改时间
     */
    public LocalDateTime getUpdateTime() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>ai_qa_system.qa_question.creator</code>. 创建者
     */
    public void setCreator(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_question.creator</code>. 创建者
     */
    public String getCreator() {
        return (String) get(9);
    }

    /**
     * Setter for <code>ai_qa_system.qa_question.is_deleted</code>. 是否删除 0: 未删除
     * 1: 已删除
     */
    public void setIsDeleted(Boolean value) {
        set(10, value);
    }

    /**
     * Getter for <code>ai_qa_system.qa_question.is_deleted</code>. 是否删除 0: 未删除
     * 1: 已删除
     */
    public Boolean getIsDeleted() {
        return (Boolean) get(10);
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
     * Create a detached QuestionRecord
     */
    public QuestionRecord() {
        super(QuestionTb.QA_QUESTION);
    }

    /**
     * Create a detached, initialised QuestionRecord
     */
    public QuestionRecord(Long id, Long questionId, String questionTitle, String questionTips, UInteger difficulty, UInteger viewCount, UByte questionStatus, LocalDateTime createTime, LocalDateTime updateTime, String creator, Boolean isDeleted) {
        super(QuestionTb.QA_QUESTION);

        setId(id);
        setQuestionId(questionId);
        setQuestionTitle(questionTitle);
        setQuestionTips(questionTips);
        setDifficulty(difficulty);
        setViewCount(viewCount);
        setQuestionStatus(questionStatus);
        setCreateTime(createTime);
        setUpdateTime(updateTime);
        setCreator(creator);
        setIsDeleted(isDeleted);
        resetChangedOnNotNull();
    }
}
