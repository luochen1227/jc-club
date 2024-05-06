package com.jingdianjichi.auth.application.controller;

import com.alibaba.fastjson2.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.converter.PermissionDtoConverter;
import com.jingdianjichi.auth.application.converter.UserDtoConverter;
import com.jingdianjichi.auth.application.dto.PermissionDto;
import com.jingdianjichi.auth.application.dto.UserDto;
import com.jingdianjichi.auth.domain.bo.PermissionBo;
import com.jingdianjichi.auth.domain.bo.UserBo;
import com.jingdianjichi.auth.domain.service.PermissionDomainService;
import com.jingdianjichi.auth.domain.service.RolePermissionDomainService;
import com.jingdianjichi.auth.domain.service.UserDomainService;
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
@RequestMapping("/permission")
@Slf4j
public class PermissionController {
    @Resource
    private PermissionDomainService permissionDomainService;

    @PostMapping("/add")
    public Result<Boolean> addRolePermission(@RequestBody PermissionDto permissionDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.addPermission.dto:{}", JSON.toJSONString(permissionDto));
            }
            Preconditions.checkNotNull(permissionDto.getId(), "id不能为空");
//            Preconditions.checkNotNull(permissionDto.getNickName(), "用户昵称不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getEmail()), "email不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPhone()), "手机号不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPassword()), "密码不能为空");
            PermissionBo permissionBo = PermissionDtoConverter.INSTANCE.convertDtoToInfoBo(permissionDto);
            Boolean b = permissionDomainService.addPermission(permissionBo);
            return Result.ok(b, "恭喜您，新增权限成功");
        } catch (Exception e) {
            log.error("UserController.registerUser.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/update")
    public Result<Boolean> updatePermission(@RequestBody PermissionDto permissionDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.updatePermission.dto:{}", JSON.toJSONString(permissionDto));
            }
            Preconditions.checkNotNull(permissionDto.getId(), "id不能为空");
//            Preconditions.checkNotNull(permissionDto.getNickName(), "用户昵称不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getEmail()), "email不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPhone()), "手机号不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPassword()), "密码不能为空");
            PermissionBo permissionBo = PermissionDtoConverter.INSTANCE.convertDtoToInfoBo(permissionDto);
            Boolean b = permissionDomainService.updatePermission(permissionBo);
            return Result.ok(b, "恭喜您，更新权限成功");
        } catch (Exception e) {
            log.error("UserController.registerUser.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/delete")
    public Result<Boolean> deletePermission(@RequestBody PermissionDto permissionDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.deletePermission.dto:{}", JSON.toJSONString(permissionDto));
            }
            Preconditions.checkNotNull(permissionDto.getId(), "id不能为空");
//            Preconditions.checkNotNull(permissionDto.getNickName(), "用户昵称不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getEmail()), "email不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPhone()), "手机号不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPassword()), "密码不能为空");
            PermissionBo permissionBo = PermissionDtoConverter.INSTANCE.convertDtoToInfoBo(permissionDto);
            Boolean b = permissionDomainService.deletePermission(permissionBo);
            return Result.ok(b, "恭喜您，删除权限成功");
        } catch (Exception e) {
            log.error("UserController.deletePermission.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
    /**
     * @description 查询用户权限
     * @param
     * @return Result<Boolean> 
     * @date 2024/4/18 15:35
     * @author 坤
     */
    
    @PostMapping("/getPermission")
    public Result<Boolean> getPermission(String userName) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.getPermission.dto:{}", userName);
            }
            Preconditions.checkArgument(!StringUtils.isBlank(userName), "id不能为空");
//            Preconditions.checkNotNull(permissionDto.getNickName(), "用户昵称不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getEmail()), "email不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPhone()), "手机号不能为空");
//            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPassword()), "密码不能为空");
            return Result.ok(permissionDomainService.getPermission(userName));
        } catch (Exception e) {
            log.error("UserController.deletePermission.err:{}", e.getMessage());
            return Result.fail("用户权限查询失败");
        }
    }
}
