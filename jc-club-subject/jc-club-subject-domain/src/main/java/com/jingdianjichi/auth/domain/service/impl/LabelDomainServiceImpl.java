package com.jingdianjichi.auth.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jingdianjichi.auth.domain.convert.LabelConvert;
import com.jingdianjichi.auth.domain.service.LabelDomainService;
import com.jingdianjichi.auth.domain.entity.LabelBo;
import com.jingdianjichi.subject.common.entity.Result;
import com.jingdianjichi.subject.common.enums.CategoryTypeEnum;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.infa.basic.entity.Category;
import com.jingdianjichi.subject.infa.basic.entity.Label;
import com.jingdianjichi.subject.infa.basic.entity.Mapping;
import com.jingdianjichi.subject.infa.basic.mapper.CategoryMapper;
import com.jingdianjichi.subject.infa.basic.mapper.LabelMapper;
import com.jingdianjichi.subject.infa.basic.mapper.MappingMapper;
import com.jingdianjichi.subject.infa.basic.service.ILabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LabelDomainServiceImpl implements LabelDomainService {
    @Resource
    private ILabelService iLabelService;
    @Resource
    private LabelMapper labelMapper;
    @Resource
    private MappingMapper mappingMapper;
    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public void addLabel(LabelBo labelBo) {
        Label label = LabelConvert.INSTANCE.convertBoToLabel(labelBo);
        labelMapper.insert(label);
        Long labelId = label.getId();
        Mapping mapping = new Mapping();
        mapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        mapping.setLabelId(labelId);
        mapping.setCategoryId(Long.valueOf(labelBo.getCategoryId()));
        mappingMapper.insert(mapping);
    }

    @Override
    public Result<Boolean> updateLabel(LabelBo labelBo) {
        Label label = LabelConvert.INSTANCE.convertBoToLabel(labelBo);
        int i = labelMapper.updateById(label);
        if (i != 0) {
            return Result.ok(true, "恭喜你，更新成功");
        }
        return Result.fail(false, "更新失败");
    }

    @Override
    public Result<Boolean> deleteLabel(LabelBo labelBo) {
        Label label = LabelConvert.INSTANCE.convertBoToLabel(labelBo);
        Long id = label.getId();
        int i = labelMapper.deleteById(id);
        if (i != 0) {
            return Result.ok(true, "恭喜你，删除成功");
        }
        return Result.fail(false, "删除失败");
    }

    @Override
    public List<LabelBo> queryLabelByCategoryId(LabelBo labelBo) {
        Integer categoryId = labelBo.getCategoryId();
        //如果当前分类是一级分类，则查询所有标签
        Category category = categoryMapper.selectById(categoryId);
        if(CategoryTypeEnum.PRIMARY.getCode() == category.getCategoryType()){
            Label subjectLabel = new Label();
            subjectLabel.setCategoryId(labelBo.getCategoryId());
            List<Label> labelList = iLabelService.queryByCondition(subjectLabel);
            List<LabelBo> labelResultList = LabelConvert.INSTANCE.convertEntityToBo(labelList);
            return labelResultList;
        }
        Label label = LabelConvert.INSTANCE.convertBoToLabel(labelBo);
        LambdaQueryWrapper<Mapping> mappingLambdaQueryWrapper = new LambdaQueryWrapper<>();
        mappingLambdaQueryWrapper.eq(Mapping::getCategoryId,label.getCategoryId());
        List<Mapping> mappings = mappingMapper.selectList(mappingLambdaQueryWrapper);
        if(CollectionUtils.isEmpty(mappings)){
            return Collections.emptyList();
        }
        List<Long> labelIdList = mappings.stream().map(Mapping::getLabelId).collect(Collectors.toList());
        List<Label> labelList = labelMapper.selectBatchIds(labelIdList);
//
//        LambdaQueryWrapper<Label> labelLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        labelLambdaQueryWrapper.eq(Label::getCategoryId,label.getCategoryId());
//        List<Label> labels = labelMapper.selectList(labelLambdaQueryWrapper);
        List<LabelBo> labelBoList = LabelConvert.INSTANCE.convertEntityToBo(labelList);
        return labelBoList;
    }
}
