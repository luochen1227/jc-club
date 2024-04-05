package com.jingdianjichi.subject.infa.basic.service;

import com.jingdianjichi.subject.infa.basic.entity.Mapping;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 题目分类关系表 服务类
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
public interface IMappingService extends IService<Mapping> {
    /**
     * 查询标签id
     */
    List<Mapping> queryLabelId(Mapping mapping);


}
