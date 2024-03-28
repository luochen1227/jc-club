package com.jingdianjichi.subject.infa.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 题目信息表
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
@TableName("subject_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 题目名称
     */
    private String subjectName;

    /**
     * 题目难度
     */
    private Byte subjectDifficult;

    /**
     * 出题人名
     */
    private String settleName;

    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Byte subjectType;

    /**
     * 题目分数
     */
    private Byte subjectScore;

    /**
     * 题目解析
     */
    private String subjectParse;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Byte getSubjectDifficult() {
        return subjectDifficult;
    }

    public void setSubjectDifficult(Byte subjectDifficult) {
        this.subjectDifficult = subjectDifficult;
    }

    public String getSettleName() {
        return settleName;
    }

    public void setSettleName(String settleName) {
        this.settleName = settleName;
    }

    public Byte getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Byte subjectType) {
        this.subjectType = subjectType;
    }

    public Byte getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(Byte subjectScore) {
        this.subjectScore = subjectScore;
    }

    public String getSubjectParse() {
        return subjectParse;
    }

    public void setSubjectParse(String subjectParse) {
        this.subjectParse = subjectParse;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Info{" +
            "id = " + id +
            ", subjectName = " + subjectName +
            ", subjectDifficult = " + subjectDifficult +
            ", settleName = " + settleName +
            ", subjectType = " + subjectType +
            ", subjectScore = " + subjectScore +
            ", subjectParse = " + subjectParse +
            ", createdBy = " + createdBy +
            ", createdTime = " + createdTime +
            ", updateBy = " + updateBy +
            ", updateTime = " + updateTime +
            ", isDeleted = " + isDeleted +
        "}";
    }
}
