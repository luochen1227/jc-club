package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.entity.LabelBo;
import com.jingdianjichi.subject.common.entity.Result;

import java.util.List;

public interface LabelDomainService {
    void addLabel(LabelBo labelBo);

    Result<Boolean> updateLabel(LabelBo labelBo);

    Result<Boolean> deleteLabel(LabelBo labelBo);

    List<LabelBo> queryLabelByCategoryId(LabelBo labelBo);
}
