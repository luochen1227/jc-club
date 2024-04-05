package com.jingdianjichi.subject.infa.basic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jingdianjichi.subject.infa.basic.entity.Info;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 题目信息表 Mapper 接口
 * </p>
 *
 * @author luochen
 * @since 2024-03-28
 */
public interface InfoMapper extends BaseMapper<Info> {

    int countByCondition(@Param("Info") Info info,
                         @Param("categoryId")Long categoryId,
                         @Param("labelId")Long labelId);

    List<Info> queryPage(@Param("Info") Info info,
                         @Param("categoryId")Long categoryId,
                         @Param("labelId") Long labelId,
                         @Param("start") int start,
                         @Param("pageSize") Integer pageSize);
}
