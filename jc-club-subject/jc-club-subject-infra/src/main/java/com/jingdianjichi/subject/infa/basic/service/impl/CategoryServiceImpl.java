package com.jingdianjichi.subject.infa.basic.service.impl;

import com.jingdianjichi.subject.infa.basic.entity.Category;
import com.jingdianjichi.subject.infa.basic.mapper.CategoryMapper;
import com.jingdianjichi.subject.infa.basic.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 题目分类 服务实现类
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public Integer querySubjectCount(Long id) {
        return categoryMapper.querySubjectCount(id);
    }
}
