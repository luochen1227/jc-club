package com.jingdianjichi.auth.domain.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jingdianjichi.auth.domain.bo.PermissionBo;
import com.jingdianjichi.auth.domain.constants.AuthConstant;
import com.jingdianjichi.auth.domain.converter.PermissionConverter;
import com.jingdianjichi.auth.domain.service.PermissionDomainService;
import com.jingdianjichi.auth.infra.entity.Permission;
import com.jingdianjichi.auth.infra.entity.Role;
import com.jingdianjichi.auth.infra.entity.RolePermission;
import com.jingdianjichi.auth.infra.mapper.PermissionMapper;
import com.jingdianjichi.auth.infra.mapper.RoleMapper;
import com.jingdianjichi.auth.infra.mapper.RolePermissionMapper;
import com.jingdianjichi.auth.infra.service.IPermissionService;
import com.jingdianjichi.enums.IsDeletedFlagEnum;
import com.jingdianjichi.utils.LocalTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Slf4j
@Service
public class PermissionDomainServiceImpl implements PermissionDomainService {

    @Resource
    private IPermissionService iPermissionService;

    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Transactional
    @Override
    public Boolean addPermission(PermissionBo permissionBo) {
        if (log.isInfoEnabled()) {
            log.info("UserController.addPermission.dto:{}", JSON.toJSONString(permissionBo));
        }
        Permission permission = PermissionConverter.INSTANCE.convertBoToEntity(permissionBo);
        permission.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        LocalDateTime localTime = LocalTimeUtil.getLocalTime();
        permission.setCreatedTime(localTime);
        int insert = permissionMapper.insert(permission);
//        Role role = new Role();
//        role.setRoleKey(AuthConstant.NORMAL_USER);
//        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        roleLambdaQueryWrapper.eq(Role::getRoleKey,role.getRoleKey());
//        Role role1 = roleMapper.selectOne(roleLambdaQueryWrapper);
//        Long roleId = role1.getId();
//        Long permissionId = permission.getId();
//        RolePermission rolePermission = new RolePermission();
//        rolePermission.setPermissionId(permissionId);
//        rolePermission.setRoleId(roleId);
//        rolePermissionMapper.insert(rolePermission);
        return insert>0;
    }

    @Override
    public Boolean updatePermission(PermissionBo permissionBo) {
        if (log.isInfoEnabled()) {
            log.info("UserController.updatePermission.dto:{}", JSON.toJSONString(permissionBo));
        }
        Permission permission = PermissionConverter.INSTANCE.convertBoToEntity(permissionBo);
        LocalDateTime localTime = LocalTimeUtil.getLocalTime();
        permission.setUpdateTime(localTime);
        int i = permissionMapper.updateById(permission);
        return i>0;
    }

    @Override
    public Boolean deletePermission(PermissionBo permissionBo) {
        if (log.isInfoEnabled()) {
            log.info("UserController.updatePermission.dto:{}", JSON.toJSONString(permissionBo));
        }
        Permission permission = PermissionConverter.INSTANCE.convertBoToEntity(permissionBo);
        int i = permissionMapper.deleteById(permission);
        return i>0;
    }
}
