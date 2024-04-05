package com.jingdianjichi.domain.service;

import com.jingdianjichi.domain.entity.CategoryBo;
import com.jingdianjichi.subject.infa.basic.entity.Category;

import java.util.List;

public interface SubjectCategoryDomainService {
    void add(CategoryBo categorybo);
    /**
     * @description  查询岗位大类
     * @param   
     * @return List<CategoryBo> 
     * @date 2024/3/29 21:36
     * @author 坤
     */
    
    List<CategoryBo> queryPrimaryCategory(Byte categoryType);
    List<CategoryBo> queryCategoryByPrimary(Byte categoryType,Long parentId);

    boolean updateCategoryById(CategoryBo categoryBo);

    boolean deleteCategoryById(CategoryBo categoryBo);
}
