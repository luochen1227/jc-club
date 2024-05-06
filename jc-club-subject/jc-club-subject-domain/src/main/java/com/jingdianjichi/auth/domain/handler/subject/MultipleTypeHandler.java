package com.jingdianjichi.auth.domain.handler.subject;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jingdianjichi.auth.domain.convert.MultipeConverter;
import com.jingdianjichi.auth.domain.entity.AnswerBo;
import com.jingdianjichi.auth.domain.entity.InfoBo;
import com.jingdianjichi.auth.domain.entity.SubjectOptionBo;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.infa.basic.entity.Multiple;
import com.jingdianjichi.subject.infa.basic.mapper.MultipleMapper;
import com.jingdianjichi.subject.infa.basic.service.IMultipleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 多选题目的策略类
 * 
 * @author: ChickenWing
 * @date: 2023/10/5
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler{

    @Resource
    private MultipleMapper multipleMapper;
    @Resource
    private IMultipleService iMultipleService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }


    @Override
    public void add(InfoBo infoBo) {
        //多选题目的插入
        List<Multiple> multiples = new LinkedList<>();
        infoBo.getOptionList().forEach(option -> {
            Multiple multiple = MultipeConverter.INSTANCE.convertBoToEntity(option);
            multiple.setSubjectId(infoBo.getId());
            multiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            multiples.add(multiple);
        });
        iMultipleService.saveBatch(multiples);
    }

    @Override
    public SubjectOptionBo query(int subjectId) {
        LambdaQueryWrapper<Multiple> multipleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        multipleLambdaQueryWrapper.eq(Multiple::getSubjectId,subjectId);
        List<Multiple> multiples = multipleMapper.selectList(multipleLambdaQueryWrapper);
        List<AnswerBo> answerBoList = MultipeConverter.INSTANCE.convertEntityToBoList(multiples);
        SubjectOptionBo subjectOptionBO = new SubjectOptionBo();
        subjectOptionBO.setOptionList(answerBoList);
        return subjectOptionBO;
    }
}
