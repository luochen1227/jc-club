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
    private Integer subjectType;

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


}
