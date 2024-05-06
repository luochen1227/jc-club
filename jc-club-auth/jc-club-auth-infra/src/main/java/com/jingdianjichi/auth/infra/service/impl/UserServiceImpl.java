package com.jingdianjichi.auth.infra.service.impl;

import com.jingdianjichi.auth.infra.entity.User;
import com.jingdianjichi.auth.infra.mapper.UserMapper;
import com.jingdianjichi.auth.infra.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author luochen
 * @since 2024-04-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
