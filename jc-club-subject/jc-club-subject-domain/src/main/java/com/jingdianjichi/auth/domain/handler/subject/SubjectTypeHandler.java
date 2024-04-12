package com.jingdianjichi.auth.domain.handler.subject;

import com.jingdianjichi.auth.domain.entity.InfoBo;
import com.jingdianjichi.auth.domain.entity.SubjectOptionBo;
import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;


public interface SubjectTypeHandler {

    /**
     * 枚举身份的识别
     */
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目的插入
     */
    void add(InfoBo subjectInfoBo);

    /**
     * 实际的题目的插入
     */
    SubjectOptionBo query(int subjectId);

}
