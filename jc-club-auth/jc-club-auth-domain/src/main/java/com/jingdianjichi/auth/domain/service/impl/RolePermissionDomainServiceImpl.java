package com.jingdianjichi.auth.domain.service.impl;

import com.alibaba.fastjson2.JSON;
import com.jingdianjichi.auth.domain.bo.PermissionBo;
import com.jingdianjichi.auth.domain.bo.RolePermissionBo;
import com.jingdianjichi.auth.domain.converter.RolePermissionConverter;
import com.jingdianjichi.auth.domain.service.RolePermissionDomainService;
import com.jingdianjichi.auth.infra.entity.RolePermission;
import com.jingdianjichi.auth.infra.mapper.RolePermissionMapper;
import com.jingdianjichi.auth.infra.service.IRolePermissionService;
import com.jingdianjichi.enums.IsDeletedFlagEnum;
import com.jingdianjichi.utils.LocalTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.LinkedList;

@Service
@Slf4j

public class RolePermissionDomainServiceImpl implements RolePermissionDomainService {
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    @Resource
    private IRolePermissionService iRolePermissionService;

    @Transactional
    @Override
    public Boolean addRolePermission(RolePermissionBo rolePermissionBo) {
        if (log.isInfoEnabled()) {
            log.info("UserController.addPermission.dto:{}", JSON.toJSONString(rolePermissionBo));
        }
        LinkedList<RolePermission> rolePermissions = new LinkedList<>();

        RolePermission rolePermission = RolePermissionConverter.INSTANCE.convertBoToEntity(rolePermissionBo);
        Long roleId = rolePermission.getRoleId();
        rolePermissionBo.getPermissionIdList().forEach(permissionId->{
            RolePermission rolePermission1 = new RolePermission();
            rolePermission1.setPermissionId(permissionId);
            rolePermission1.setRoleId(roleId);
            rolePermission1.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            LocalDateTime localTime = LocalTimeUtil.getLocalTime();
            rolePermission1.setCreatedTime(localTime);
            rolePermissions.add(rolePermission1);
        });
        boolean b = iRolePermissionService.saveBatch(rolePermissions);
        return b;
    }
}
