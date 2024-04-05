package com.jingdianjichi.subject.infa.basic.service.impl;

import com.jingdianjichi.subject.infa.basic.entity.Mapping;
import com.jingdianjichi.subject.infa.basic.mapper.MappingMapper;
import com.jingdianjichi.subject.infa.basic.service.IMappingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 题目分类关系表 服务实现类
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
@Service
public class MappingServiceImpl extends ServiceImpl<MappingMapper, Mapping> implements IMappingService {
    @Resource
    private MappingMapper mappingMapper;

    @Override
    public List<Mapping> queryLabelId(Mapping mapping) {
        return this.mappingMapper.queryDistinctLabelId(mapping);
    }
}
