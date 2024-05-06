package com.jingdianjichi.subject.infa.basic.service;

import com.jingdianjichi.subject.infa.basic.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 题目分类 服务类
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
public interface ICategoryService extends IService<Category> {

    Integer querySubjectCount(Long id);
}
