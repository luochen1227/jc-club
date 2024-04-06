package com.jingdianjichi.subject.infa.basic.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jingdianjichi.subject.infa.basic.entity.Label;

import java.util.List;

/**
 * <p>
 * 题目标签表 Mapper 接口
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
public interface LabelMapper extends BaseMapper<Label> {

    List<Label> queryByCondition(Label subjectLabel);
}
