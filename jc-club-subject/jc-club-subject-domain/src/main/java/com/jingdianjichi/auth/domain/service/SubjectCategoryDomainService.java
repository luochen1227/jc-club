package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.CategoryBo;

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

    List<CategoryBo> queryCategoryAndLabel(CategoryBo categoryBo);
}
