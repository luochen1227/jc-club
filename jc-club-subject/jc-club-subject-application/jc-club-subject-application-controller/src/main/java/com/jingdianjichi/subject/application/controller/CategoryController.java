package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson2.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.domain.entity.CategoryBo;
import com.jingdianjichi.auth.domain.service.SubjectCategoryDomainService;
import com.jingdianjichi.subject.application.convert.CategoryDtoConvert;
import com.jingdianjichi.subject.application.dto.CategoryDto;
import com.jingdianjichi.subject.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 题目分类 前端控制器
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class CategoryController {
    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody CategoryDto categoryDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("CategoryController.add.dto:{}", JSON.toJSONString(categoryDto));
            }
            Preconditions.checkNotNull(categoryDto.getCategoryType(), "分类类型不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(categoryDto.getCategoryName()), "分类名字不能为空");
            Preconditions.checkNotNull(categoryDto.getParentId(), "分类父id不能为空");
            CategoryBo categoryBo = CategoryDtoConvert.INSTANCE.convertDtoToCategoryBo(categoryDto);
            subjectCategoryDomainService.add(categoryBo);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("CategoryController.add.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/queryPrimaryCategory")
    public Result<List<CategoryDto>> queryPrimaryCategory(@RequestBody CategoryDto categoryDto) {
        try {
            Byte categoryType = categoryDto.getCategoryType();
            List<CategoryBo> categoryBoList = subjectCategoryDomainService.queryPrimaryCategory(categoryType);
            List<CategoryDto> categoryDtoList = CategoryDtoConvert.INSTANCE.convertBoToCategoryDtoList(categoryBoList);
            return Result.ok(categoryDtoList);
        } catch (Exception e) {
            log.error("CategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }

    }

    @PostMapping("/queryCategoryByPrimary")
    public Result<List<CategoryDto>> queryCategoryByPrimary(@RequestBody CategoryDto categoryDto) {
        try {
            Byte categoryType = categoryDto.getCategoryType();
            Long parentId = categoryDto.getParentId();
            List<CategoryBo> categoryBoList = subjectCategoryDomainService.queryCategoryByPrimary(categoryType, parentId);
            List<CategoryDto> categoryDtoList = CategoryDtoConvert.INSTANCE.convertBoToCategoryDtoList(categoryBoList);
            return Result.ok(categoryDtoList);
        } catch (Exception e) {
            log.error("CategoryController.queryPrimaryCategory.error:{}", e.getMessage(), e);
            return Result.fail("查询失败");
        }

    }

    @PostMapping("/update")
    public Result<Boolean> updateCategoryById(@RequestBody CategoryDto categoryDto) {
        try {
            CategoryBo categoryBo = CategoryDtoConvert.INSTANCE.convertDtoToCategoryBo(categoryDto);
            boolean b = subjectCategoryDomainService.updateCategoryById(categoryBo);
            return Result.ok(b);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Result.fail(false);
        }
    }

    @PostMapping("/delete")
    public Result<Boolean> deleteCategoryById(@RequestBody CategoryDto categoryDto) {
        try {
            CategoryBo categoryBo = CategoryDtoConvert.INSTANCE.convertDtoToCategoryBo(categoryDto);
            boolean b = subjectCategoryDomainService.deleteCategoryById(categoryBo);
            return Result.ok(b);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return Result.fail(false);
        }
    }
}
