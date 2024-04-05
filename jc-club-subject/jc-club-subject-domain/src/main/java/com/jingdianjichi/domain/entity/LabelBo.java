package com.jingdianjichi.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 题目标签表
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LabelBo implements Serializable {

    private Long id;

    /**
     * 标签分类
     */
    private String labelName;

    /**
     * 排序
     */
    private Integer sortNum;

    private String categoryId;


}
