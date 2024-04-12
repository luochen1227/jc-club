package com.jingdianjichi.auth.application.controller;

import com.alibaba.fastjson2.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.converter.RoleDtoConverter;
import com.jingdianjichi.auth.application.converter.UserDtoConverter;
import com.jingdianjichi.auth.application.dto.RoleDto;
import com.jingdianjichi.auth.application.dto.UserDto;
import com.jingdianjichi.auth.domain.bo.RoleBo;
import com.jingdianjichi.auth.domain.bo.UserBo;
import com.jingdianjichi.auth.domain.service.RoleDomainService;
import com.jingdianjichi.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luochen
 * @since 2024-04-09
 */
@RestController
@RequestMapping("/role")
@Slf4j
public class RoleController {
    @Resource
    private RoleDomainService roleDomainService;


    @PostMapping("/add")
    public Result<Boolean> addRole(@RequestBody RoleDto roleDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.addRole.dto:{}", JSON.toJSONString(roleDto));
            }
            Preconditions.checkArgument(!StringUtils.isBlank(roleDto.getRoleName()), "角色名称不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(roleDto.getRoleKey()), "角色唯一标识不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPassword()), "密码不能为空");
            RoleBo roleBo = RoleDtoConverter.INSTANCE.convertDtoToInfoBo(roleDto);
            Boolean b = roleDomainService.addRole(roleBo);

            return Result.ok(b, "新增权限成功");
        } catch (Exception e) {
            log.error("RoleController.addRole.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/update")
    public Result<Boolean> updateRole(@RequestBody RoleDto roleDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.updateRole.dto:{}", JSON.toJSONString(roleDto));
            }
            Preconditions.checkNotNull(roleDto.getId(),"权限id不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(roleDto.getRoleName()), "角色名称不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(roleDto.getRoleKey()), "角色唯一标识不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPassword()), "密码不能为空");
            RoleBo roleBo = RoleDtoConverter.INSTANCE.convertDtoToInfoBo(roleDto);
            Boolean b = roleDomainService.updateRole(roleBo);
            return Result.ok(b, "更新权限成功");
        } catch (Exception e) {
            log.error("RoleController.updateRole.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/delete")
    public Result<Boolean> deleteRoleById(@RequestBody RoleDto roleDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("RoleController.deleteRoleById.dto:{}", JSON.toJSONString(roleDto));
            }
            Preconditions.checkNotNull(roleDto.getId(),"权限id不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPassword()), "密码不能为空");
            RoleBo roleBo = RoleDtoConverter.INSTANCE.convertDtoToInfoBo(roleDto);
            Boolean b = roleDomainService.deleteRoleById(roleBo);
            return Result.ok(b, "删除权限成功");
        } catch (Exception e) {
            log.error("RoleController.deleteRoleById.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

}
