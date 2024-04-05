package com.jingdianjichi.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.jingdianjichi.subject.common.entity.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

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
public class SubjectOptionBo extends PageInfo implements Serializable {


    /**
     * 题目答案
     */
    private String subjectAnswer;

    /**
     * 答案选项
     */
    private List<AnswerBo> optionList;


}
