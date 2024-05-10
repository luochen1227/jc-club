package com.jingdianjichi.auth.domain.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jingdianjichi.auth.domain.entity.LabelBo;
import com.jingdianjichi.auth.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.auth.domain.convert.CategoryConvert;
import com.jingdianjichi.auth.domain.entity.CategoryBo;

import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.infa.basic.entity.Category;

import com.jingdianjichi.subject.infa.basic.entity.Label;
import com.jingdianjichi.subject.infa.basic.entity.Mapping;
import com.jingdianjichi.subject.infa.basic.mapper.CategoryMapper;
import com.jingdianjichi.subject.infa.basic.mapper.LabelMapper;
import com.jingdianjichi.subject.infa.basic.service.ICategoryService;
import com.jingdianjichi.subject.infa.basic.service.ILabelService;
import com.jingdianjichi.subject.infa.basic.service.IMappingService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.util.MapUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {
    @Resource
    private ICategoryService categoryService;
    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private IMappingService iMappingService;
    @Resource
    private ILabelService iLabelService;
    @Resource
    private LabelMapper labelMapper;
    @Resource
    private ThreadPoolExecutor labelThreadPool;

    @Override
    public void add(CategoryBo categorybo) {
        if (log.isInfoEnabled()) {
            log.info("CategoryController.add.bo:{}", JSON.toJSONString(categorybo));
        }
        Category category = CategoryConvert.INSTANCE.convertBoToCategory(categorybo);
        categoryService.save(category);
    }

    @Override
    public List<CategoryBo> queryPrimaryCategory(Byte categoryType) {
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getCategoryType, categoryType);
        categoryLambdaQueryWrapper.eq(Category::getIsDeleted, 0);
        categoryLambdaQueryWrapper.eq(Category::getParentId, 0);
        List<Category> list = categoryService.list(categoryLambdaQueryWrapper);
        List<CategoryBo> categoryBoList = CategoryConvert.INSTANCE.convertEntityToBo(list);
        if (log.isInfoEnabled()) {
            log.info("CategoryController.queryPrimaryCategory.categoryBoList:{}", JSON.toJSONString(categoryBoList));
        }
        categoryBoList.forEach(bo -> {
            Integer subjectCount = categoryService.querySubjectCount(bo.getId());
            bo.setCount(subjectCount);
        });
        return categoryBoList;
    }

    @Override
    public List<CategoryBo> queryCategoryByPrimary(Byte categoryType, Long parentId) {
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getCategoryType, categoryType);
        categoryLambdaQueryWrapper.eq(Category::getIsDeleted, 0);
        categoryLambdaQueryWrapper.eq(Category::getParentId, parentId);
        List<Category> list = categoryService.list(categoryLambdaQueryWrapper);
        List<CategoryBo> categoryBoList = CategoryConvert.INSTANCE.convertEntityToBo(list);
        if (log.isInfoEnabled()) {
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
        return i > 0;
    }

    @SneakyThrows
    @Override
    public List<CategoryBo> queryCategoryAndLabel(CategoryBo categoryBo) {
        //查询当前大类下所有分类
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        categoryLambdaQueryWrapper.eq(Category::getParentId, categoryBo.getId());
        List<Category> categoryList = categoryMapper.selectList(categoryLambdaQueryWrapper);
        List<CategoryBo> categoryBoList = CategoryConvert.INSTANCE.convertEntityToBo(categoryList);
        //一次获取标签信息
        List<FutureTask<Map<Long, List<LabelBo>>>> futureTaskList = new LinkedList<>();
        Map<Long, List<LabelBo>> map = new HashMap<>();
        //线程池并发调用
        categoryBoList.forEach(category -> {
            FutureTask<Map<Long, List<LabelBo>>> futureTask = new FutureTask<>(() ->
                    getLabelBoList(category));
            futureTaskList.add(futureTask);
            labelThreadPool.submit(futureTask);
        });
        for (FutureTask<Map<Long, List<LabelBo>>> futureTask : futureTaskList) {
            Map<Long, List<LabelBo>> resultMap = futureTask.get();
            if (CollectionUtils.isEmpty(resultMap)){
                continue;
            }
            map.putAll(resultMap);
        }
        categoryBoList.forEach(categoryBo1 -> {
            categoryBo1.setLabelBoList(map.get(categoryBo1.getId()));
        });
        return categoryBoList;
    }

    private Map<Long, List<LabelBo>> getLabelBoList(CategoryBo category) {
        Map<Long, List<LabelBo>> labelMap = new HashMap<>();
        Mapping mapping = new Mapping();
        mapping.setCategoryId(category.getId());
        List<Mapping> mappingList = iMappingService.queryLabelId(mapping);
        if (CollectionUtils.isEmpty(mappingList)) {
            return null;
        }
        List<Long> labelIdList = mappingList.stream().map(Mapping::getLabelId).collect(Collectors.toList());
        List<Label> labelList = labelMapper.selectBatchIds(labelIdList);
        List<LabelBo> labelBos = new LinkedList<>();
        labelList.forEach(label -> {
            LabelBo labelBo = new LabelBo();
            labelBo.setId(label.getId());
            labelBo.setLabelName(label.getLabelName());
            labelBo.setCategoryId(label.getCategoryId());
            labelBo.setSortNum(label.getSortNum());
            labelBos.add(labelBo);
        });
        labelMap.put(category.getId(), labelBos);
        return labelMap;
    }
}
