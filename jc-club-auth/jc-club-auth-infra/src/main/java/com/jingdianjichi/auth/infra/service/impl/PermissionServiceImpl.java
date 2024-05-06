package com.jingdianjichi.auth.infra.service.impl;

import com.jingdianjichi.auth.infra.entity.Permission;
import com.jingdianjichi.auth.infra.mapper.PermissionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jingdianjichi.auth.infra.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
