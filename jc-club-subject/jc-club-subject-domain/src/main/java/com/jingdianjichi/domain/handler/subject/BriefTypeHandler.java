package com.jingdianjichi.domain.handler.subject;


import com.jingdianjichi.domain.convert.BriefConvert;
import com.jingdianjichi.domain.entity.InfoBo;
import com.jingdianjichi.domain.entity.SubjectOptionBo;
import com.jingdianjichi.subject.common.enums.IsDeletedFlagEnum;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.infa.basic.entity.Brief;
import com.jingdianjichi.subject.infa.basic.service.IBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 简答题目的策略类
 * 
 * @author: ChickenWing
 * @date: 2023/10/5
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{

    @Resource
    private IBriefService iBriefService;
    
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(InfoBo infoBo) {
        Brief brief = BriefConvert.INSTANCE.convertBoToEntity(infoBo);
        brief.setSubjectId(Math.toIntExact((infoBo.getId())));
        brief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        iBriefService.save(brief);
    }

    @Override
    public SubjectOptionBo query(int subjectId) {
        Brief byId = iBriefService.getById(subjectId);
        SubjectOptionBo subjectOptionBo = new SubjectOptionBo();
        subjectOptionBo.setSubjectAnswer(byId.getSubjectAnswer());
        return subjectOptionBo;
    }

//    @Override
//    public SubjectOptionBO query(int subjectId) {
//        SubjectBrief subjectBrief = new SubjectBrief();
//        subjectBrief.setSubjectId(subjectId);
//        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
//        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
//        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
//        return subjectOptionBO;
//    }
}
