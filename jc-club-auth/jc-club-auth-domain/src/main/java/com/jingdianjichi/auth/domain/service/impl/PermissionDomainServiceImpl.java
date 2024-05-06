package com.jingdianjichi.auth.domain.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.jingdianjichi.auth.domain.bo.PermissionBo;
import com.jingdianjichi.auth.domain.constants.AuthConstant;
import com.jingdianjichi.auth.domain.converter.PermissionConverter;
import com.jingdianjichi.auth.domain.redis.RedisUtil;
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
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource
    private RedisUtil redisUtil;
    private String authPermissionPrefix = "auth.permission";
    private String authRolePrefix = "auth.role";

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
        return insert > 0;
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
        return i > 0;
    }

    @Override
    public Boolean deletePermission(PermissionBo permissionBo) {
        if (log.isInfoEnabled()) {
            log.info("UserController.updatePermission.dto:{}", JSON.toJSONString(permissionBo));
        }
        Permission permission = PermissionConverter.INSTANCE.convertBoToEntity(permissionBo);
        int i = permissionMapper.deleteById(permission);
        return i > 0;
    }

    @Override
    public List<String> getPermission(String userName) {
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, userName);
        String permissionValue = redisUtil.get(permissionKey);
        if (StringUtils.isBlank(permissionValue)){
            return Collections.emptyList();
        }
        List<Permission> permissionsList = new Gson().fromJson(permissionValue, new TypeToken<List<Permission>>() {
        }.getType());
        List<String> authList = permissionsList.stream().map(Permission::getPermissionKey).collect(Collectors.toList());
        return authList;
    }
}
