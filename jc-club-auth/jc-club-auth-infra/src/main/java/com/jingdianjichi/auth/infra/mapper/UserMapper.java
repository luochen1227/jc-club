package com.jingdianjichi.auth.infra.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jingdianjichi.auth.infra.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author luochen
 * @since 2024-04-09
 */
public interface UserMapper extends BaseMapper<User> {
    void updateUser(User user);


}
