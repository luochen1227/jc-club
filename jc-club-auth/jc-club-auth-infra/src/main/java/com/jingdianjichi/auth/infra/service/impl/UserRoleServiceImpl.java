package com.jingdianjichi.auth.infra.service.impl;

import com.jingdianjichi.auth.infra.entity.UserRole;
import com.jingdianjichi.auth.infra.mapper.UserRoleMapper;
import com.jingdianjichi.auth.infra.service.IUserRoleService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author luochen
 * @since 2024-04-09
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
