package com.jingdianjichi.auth.domain.service.impl;

import com.alibaba.fastjson2.JSON;
import com.jingdianjichi.auth.domain.bo.RoleBo;
import com.jingdianjichi.auth.domain.converter.RoleConverter;

import com.jingdianjichi.auth.domain.service.RoleDomainService;
import com.jingdianjichi.auth.infra.entity.Role;
import com.jingdianjichi.auth.infra.mapper.RoleMapper;
import com.jingdianjichi.auth.infra.service.IRoleService;
import com.jingdianjichi.enums.IsDeletedFlagEnum;
import com.jingdianjichi.utils.LocalTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
@Slf4j
public class RoleDomainServiceImpl implements RoleDomainService {

    @Resource
    private RoleMapper roleMapper;
    @Resource
    private IRoleService roleService;


    @Override
    @Transactional
    public Boolean addRole(RoleBo roleBo) {
        if (log.isInfoEnabled()) {
            log.info("RoleDomainServiceImpl.addRole.bo:{}", JSON.toJSONString(roleBo));
        }
        LocalDateTime localTime = LocalTimeUtil.getLocalTime();
        Role role = RoleConverter.INSTANCE.convertBoToEntity(roleBo);
        role.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        role.setCreatedTime(localTime);
        int insert = roleMapper.insert(role);
        return insert>0;
    }

    @Override
    public Boolean updateRole(RoleBo roleBo) {
        if (log.isInfoEnabled()) {
            log.info("RoleDomainServiceImpl.updateRole.bo:{}", JSON.toJSONString(roleBo));
        }
        LocalDateTime localTime = LocalTimeUtil.getLocalTime();
        Role role = RoleConverter.INSTANCE.convertBoToEntity(roleBo);
        role.setUpdateTime(localTime);
        int i = roleMapper.updateById(role);
        return i>0;
    }

    @Override
    public Boolean deleteRoleById(RoleBo roleBo) {
        if (log.isInfoEnabled()) {
            log.info("RoleDomainServiceImpl.updateRole.bo:{}", JSON.toJSONString(roleBo));
        }
        Role role = RoleConverter.INSTANCE.convertBoToEntity(roleBo);
        int i = roleMapper.deleteById(role);
        return i>0;
    }
}
