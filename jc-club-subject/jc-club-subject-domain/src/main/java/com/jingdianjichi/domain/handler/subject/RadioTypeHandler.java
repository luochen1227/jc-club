package com.jingdianjichi.domain.handler.subject;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jingdianjichi.domain.convert.MultipeConverter;
import com.jingdianjichi.domain.convert.RadioConvert;
import com.jingdianjichi.domain.entity.AnswerBo;
import com.jingdianjichi.domain.entity.InfoBo;

import com.jingdianjichi.domain.entity.SubjectOptionBo;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.infa.basic.entity.Multiple;
import com.jingdianjichi.subject.infa.basic.entity.Radio;
import com.jingdianjichi.subject.infa.basic.mapper.RadioMapper;
import com.jingdianjichi.subject.infa.basic.service.IRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;


/**
 * 单选题目的策略类
 *
 * @author: ChickenWing
 * @date: 2023/10/5
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler {

    @Resource
    private IRadioService iRadioService;
    @Resource
    private RadioMapper radioMapper;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(InfoBo subjectInfoBo) {
        //单选题目的插入
        List<Radio> RadioList = new LinkedList<>();
        subjectInfoBo.getOptionList().forEach(option -> {
            Radio radio = RadioConvert.INSTANCE.convertBoToEntity(option);
            radio.setSubjectId(subjectInfoBo.getId());
            radio.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            RadioList.add(radio);
        });
        iRadioService.saveBatch(RadioList);

    }

    @Override
    public SubjectOptionBo query(int subjectId) {
        LambdaQueryWrapper<Radio> radioLambdaQueryWrapper = new LambdaQueryWrapper<>();
        radioLambdaQueryWrapper.eq(Radio::getSubjectId,subjectId);
        List<Radio> radioList = radioMapper.selectList(radioLambdaQueryWrapper);
        List<AnswerBo> answerBoList = RadioConvert.INSTANCE.convertEntityToBoList(radioList);
        SubjectOptionBo subjectOptionBO = new SubjectOptionBo();
        subjectOptionBO.setOptionList(answerBoList);
        return subjectOptionBO;
    }

}
