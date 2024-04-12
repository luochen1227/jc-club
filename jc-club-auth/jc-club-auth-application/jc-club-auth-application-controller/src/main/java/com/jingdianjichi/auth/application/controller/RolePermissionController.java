package com.jingdianjichi.auth.application.controller;

import com.alibaba.fastjson2.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.converter.PermissionDtoConverter;
import com.jingdianjichi.auth.application.converter.RolePermissionDtoConverter;
import com.jingdianjichi.auth.application.dto.PermissionDto;
import com.jingdianjichi.auth.application.dto.RolePermissionDto;
import com.jingdianjichi.auth.domain.bo.PermissionBo;
import com.jingdianjichi.auth.domain.bo.RolePermissionBo;
import com.jingdianjichi.auth.domain.service.RolePermissionDomainService;
import com.jingdianjichi.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 角色权限关联表 前端控制器
 * </p>
 *
 * @author luochen
 * @since 2024-04-09
 */
@RestController
@RequestMapping("/rolePermission")
@Slf4j
public class RolePermissionController {
    @Resource
    private RolePermissionDomainService rolePermissionDomainService;

    @PostMapping("/add")
    public Result<Boolean> addRolePermission(@RequestBody RolePermissionDto rolePermissionDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.addPermission.dto:{}", JSON.toJSONString(rolePermissionDto));
            }
            Preconditions.checkNotNull(rolePermissionDto.getRoleId(), "角色id不能为空");
//            Preconditions.checkNotNull(permissionDto.getNickName(), "用户昵称不能为空");
            Preconditions.checkArgument(!CollectionUtils.isEmpty(rolePermissionDto.getPermissionIdList()), "权限id列表不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPhone()), "手机号不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPassword()), "密码不能为空");
            RolePermissionBo rolePermissionBo = RolePermissionDtoConverter.INSTANCE.convertDtoToInfoBo(rolePermissionDto);
            Boolean b = rolePermissionDomainService.addRolePermission(rolePermissionBo);
            return Result.ok(b, "恭喜您，新增角色权限成功");
        } catch (Exception e) {
            log.error("UserController.registerUser.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

}
