package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.InfoBo;
import com.jingdianjichi.subject.common.entity.PageResult;

public interface InfoDomainService {
    void addInfo(InfoBo infoBo);

    PageResult<InfoBo> getSubjectPage(InfoBo infoBo);

    InfoBo querySubjectInfo(InfoBo infoBo);
}
