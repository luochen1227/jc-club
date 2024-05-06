package com.jingdianjichi.auth.infra.service.impl;

import com.jingdianjichi.auth.infra.entity.Role;
import com.jingdianjichi.auth.infra.mapper.RoleMapper;
import com.jingdianjichi.auth.infra.service.IRoleService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luochen
 * @since 2024-04-09
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
