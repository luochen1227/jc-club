package com.jingdianjichi.auth.domain.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jingdianjichi.auth.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.auth.domain.convert.CategoryConvert;
import com.jingdianjichi.auth.domain.entity.CategoryBo;

import com.jingdianjichi.subject.infa.basic.entity.Category;

import com.jingdianjichi.subject.infa.basic.mapper.CategoryMapper;
import com.jingdianjichi.subject.infa.basic.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {
    @Resource
    private ICategoryService categoryService;
    @Resource
    private CategoryMapper categoryMapper;



    @Override
    public void add(CategoryBo categorybo) {
        if (log.isInfoEnabled()){
            log.info("CategoryController.add.bo:{}", JSON.toJSONString(categorybo));
        }
        Category category = CategoryConvert.INSTANCE.convertBoToCategory(categorybo);
        categoryService.save(category);
    }

    @Override
    public List<CategoryBo> queryPrimaryCategory(Byte categoryType) {
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getCategoryType,categoryType);
        categoryLambdaQueryWrapper.eq(Category::getIsDeleted,0);
        List<Category> list = categoryService.list(categoryLambdaQueryWrapper);
        List<CategoryBo> categoryBoList = CategoryConvert.INSTANCE.convertEntityToBo(list);
        if (log.isInfoEnabled()){
            log.info("CategoryController.queryPrimaryCategory.categoryBoList:{}", JSON.toJSONString(categoryBoList));
        }
        return categoryBoList;
    }

    @Override
    public List<CategoryBo> queryCategoryByPrimary(Byte categoryType, Long parentId) {
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getCategoryType,categoryType);
        categoryLambdaQueryWrapper.eq(Category::getIsDeleted,0);
        categoryLambdaQueryWrapper.eq(Category::getParentId,parentId);
        List<Category> list = categoryService.list(categoryLambdaQueryWrapper);
        List<CategoryBo> categoryBoList = CategoryConvert.INSTANCE.convertEntityToBo(list);
        if (log.isInfoEnabled()){
            log.info("CategoryController.queryCategoryByPrimary.categoryBoList:{}", JSON.toJSONString(categoryBoList));
        }
        return categoryBoList;
    }

    @Override
    public boolean updateCategoryById(CategoryBo categoryBo) {
        Category category = CategoryConvert.INSTANCE.convertBoToCategory(categoryBo);
        return categoryService.updateById(category);

    }

    @Override
    public boolean deleteCategoryById(CategoryBo categoryBo) {
        Category category = CategoryConvert.INSTANCE.convertBoToCategory(categoryBo);
        Long id = category.getId();
        int i = categoryMapper.deleteById(id);
        return i>0;
    }
}
