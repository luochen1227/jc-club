package com.jingdianjichi.subject.infa.basic.service;

import com.jingdianjichi.subject.infa.basic.entity.Label;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 题目标签表 服务类
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
public interface ILabelService extends IService<Label> {
    List<Label> queryByCondition(Label subjectLabel);

}
