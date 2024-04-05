package com.jingdianjichi.subject.application.controller;

import com.alibaba.fastjson2.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.domain.entity.CategoryBo;
import com.jingdianjichi.domain.entity.LabelBo;
import com.jingdianjichi.domain.service.LabelDomainService;
import com.jingdianjichi.subject.application.convert.CategoryDtoConvert;
import com.jingdianjichi.subject.application.convert.LabelDtoConvert;
import com.jingdianjichi.subject.application.dto.CategoryDto;
import com.jingdianjichi.subject.application.dto.LabelDto;
import com.jingdianjichi.subject.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 题目标签表 前端控制器
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class LabelController {
    @Resource
    private LabelDomainService labelDomainService;
    @PostMapping("/add")
    public Result<Boolean> addLabel(@RequestBody LabelDto labelDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("LabelController.addLabel.dto:{}", JSON.toJSONString(labelDto));
            }
            Preconditions.checkNotNull(labelDto.getLabelName(), "标签分类不能为空");
            Preconditions.checkNotNull(labelDto.getSortNum(), "排序不能为空");
            Preconditions.checkNotNull(labelDto.getCategoryId(), "分类不能为空");
            LabelBo labelBo = LabelDtoConvert.INSTANCE.convertDtoToLabelBo(labelDto);
            labelDomainService.addLabel(labelBo);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("CategoryController.add.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
    @PostMapping("/update")
    public Result<Boolean> updateLabel(@RequestBody LabelDto labelDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("LabelController.updateLabel.dto:{}", JSON.toJSONString(labelDto));
            }
//            Preconditions.checkNotNull(labelDto.getLabelName(), "标签分类不能为空");
//            Preconditions.checkNotNull(labelDto.getSortNum(), "排序不能为空");
//            Preconditions.checkNotNull(labelDto.getCategoryId(), "分类不能为空");
            LabelBo labelBo = LabelDtoConvert.INSTANCE.convertDtoToLabelBo(labelDto);
            Result<Boolean> booleanResult = labelDomainService.updateLabel(labelBo);
            return booleanResult;
        } catch (Exception e) {
            log.error("CategoryController.add.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
    @PostMapping("/delete")
    public Result<Boolean> deleteLabel(@RequestBody LabelDto labelDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("LabelController.deleteLabel.dto:{}", JSON.toJSONString(labelDto));
            }
//            Preconditions.checkNotNull(labelDto.getLabelName(), "标签分类不能为空");
//            Preconditions.checkNotNull(labelDto.getSortNum(), "排序不能为空");
//            Preconditions.checkNotNull(labelDto.getCategoryId(), "分类不能为空");
            LabelBo labelBo = LabelDtoConvert.INSTANCE.convertDtoToLabelBo(labelDto);
            Result<Boolean> booleanResult = labelDomainService.deleteLabel(labelBo);
            return booleanResult;
        } catch (Exception e) {
            log.error("CategoryController.add.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
    @PostMapping("/queryLabelByCategoryId")
    public Result<List<LabelDto>> queryLabelByCategoryId(@RequestBody LabelDto labelDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("LabelController.queryLabelByCategoryId.dto:{}", JSON.toJSONString(labelDto));
            }
//            Preconditions.checkNotNull(labelDto.getLabelName(), "标签分类不能为空");
//            Preconditions.checkNotNull(labelDto.getSortNum(), "排序不能为空");
            Preconditions.checkNotNull(labelDto.getCategoryId(), "分类id不能为空");
            LabelBo labelBo = LabelDtoConvert.INSTANCE.convertDtoToLabelBo(labelDto);
            List<LabelBo> labelBoList = labelDomainService.queryLabelByCategoryId(labelBo);
            List<LabelDto> labelDtoList = LabelDtoConvert.INSTANCE.convertBoToCategoryDtoList(labelBoList);
            return Result.ok(labelDtoList,"查询成功");
        } catch (Exception e) {
            log.error("CategoryController.add.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

}
