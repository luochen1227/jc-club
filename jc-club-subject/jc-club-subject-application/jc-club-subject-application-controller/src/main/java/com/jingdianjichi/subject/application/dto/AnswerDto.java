package com.jingdianjichi.subject.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @description  题目答案dto
 * @date 2024/3/30 14:37
 * @author 坤
 */

@Data
public class AnswerDto implements Serializable {
    /**
     * 答案选项标识
     */
    private Integer optionType;
    /**
     * 答案
     */
    private String optionContent;
    /**
     * 是否正确
     */
    private Integer isCorrect;



}
