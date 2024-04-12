package com.jingdianjichi.auth.infra.service.impl;

import com.jingdianjichi.auth.infra.entity.RolePermission;
import com.jingdianjichi.auth.infra.mapper.RolePermissionMapper;
import com.jingdianjichi.auth.infra.service.IRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限关联表 服务实现类
 * </p>
 *
 * @author luochen
 * @since 2024-04-09
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

}
