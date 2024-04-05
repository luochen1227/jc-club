package com.jingdianjichi.domain.service;

import com.jingdianjichi.domain.entity.InfoBo;
import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.common.entity.Result;

public interface InfoDomainService {
    void addInfo(InfoBo infoBo);

    PageResult<InfoBo> getSubjectPage(InfoBo infoBo);

    InfoBo querySubjectInfo(InfoBo infoBo);
}
