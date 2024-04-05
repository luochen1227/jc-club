package com.jingdianjichi.subject.infa.basic.service.impl;

import com.jingdianjichi.subject.infa.basic.entity.Info;
import com.jingdianjichi.subject.infa.basic.mapper.InfoMapper;
import com.jingdianjichi.subject.infa.basic.service.IInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 题目信息表 服务实现类
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements IInfoService {
    @Resource
    private InfoMapper InfoMapper;
    @Override
    public int countByCondition(Info info, Long categoryId, Long labelId) {
        return this.InfoMapper.countByCondition( info,  categoryId,  labelId);
    }

    @Override
    public List<Info> queryPage(Info info, Long categoryId, Long labelId, int start, Integer pageSize) {
        return this.InfoMapper.queryPage( info,categoryId,labelId,start,pageSize);
    }
}
