package com.jingdianjichi.subject.infa.basic.service;

import com.jingdianjichi.subject.infa.basic.entity.Info;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 题目信息表 服务类
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
public interface IInfoService extends IService<Info> {

    int countByCondition(Info info, Long categoryId, Long labelId);

    List<Info> queryPage(Info info, Long categoryId, Long labelId, int start, Integer pageSize);
}
