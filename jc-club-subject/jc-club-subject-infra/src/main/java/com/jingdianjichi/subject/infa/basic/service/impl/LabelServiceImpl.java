package com.jingdianjichi.subject.infa.basic.service.impl;

import com.jingdianjichi.subject.infa.basic.entity.Label;
import com.jingdianjichi.subject.infa.basic.mapper.LabelMapper;
import com.jingdianjichi.subject.infa.basic.service.ILabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 题目标签表 服务实现类
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements ILabelService {
    @Resource
    private LabelMapper labelMapper;

    @Override
    public List<Label> queryByCondition(Label subjectLabel) {
        return this.labelMapper.queryByCondition(subjectLabel);
    }
}
