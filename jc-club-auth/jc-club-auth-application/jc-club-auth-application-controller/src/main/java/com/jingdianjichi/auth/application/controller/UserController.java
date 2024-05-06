package com.jingdianjichi.auth.application.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSON;
import com.google.common.base.Preconditions;
import com.jingdianjichi.auth.application.converter.UserDtoConverter;
import com.jingdianjichi.auth.application.dto.UserDto;
import com.jingdianjichi.auth.domain.bo.UserBo;
import com.jingdianjichi.auth.domain.service.UserDomainService;
import com.jingdianjichi.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserDomainService userDomainService;

    @PostMapping("/register")
    public Result<Boolean> registerUser(@RequestBody UserDto userDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.registerUser.dto:{}", JSON.toJSONString(userDto));
            }
            Preconditions.checkNotNull(userDto.getUserName(), "名称/账号");
            Preconditions.checkNotNull(userDto.getNickName(), "用户昵称不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getEmail()), "email不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPhone()), "手机号不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(userDto.getPassword()), "密码不能为空");
            UserBo userBo = UserDtoConverter.INSTANCE.convertDtoToInfoBo(userDto);
            Boolean b = userDomainService.registerUser(userBo);
            if (b != true) {
                return Result.fail(b, "用户名已存在");
            }
            return Result.ok(b, "恭喜您，创建用户成功");
        } catch (Exception e) {
            log.error("UserController.registerUser.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/update")
    public Result<Boolean> updateUser(@RequestBody UserDto userDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.updateUser.dto:{}", JSON.toJSONString(userDto));
            }
            Preconditions.checkNotNull(userDto.getUserName(), "用户名称/账号");

            UserBo userBo = UserDtoConverter.INSTANCE.convertDtoToInfoBo(userDto);
            int i = userDomainService.updateUser(userBo);
            if (i > 0) {
                return Result.ok(true, "恭喜您，更新用户成功");

            } else {
                return Result.fail(false, "失败");
            }
        } catch (Exception e) {
            log.error("UserController.updateUser.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/delete")
    public Result<Boolean> deleteUser(@RequestBody UserDto userDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.deleteUser.dto:{}", JSON.toJSONString(userDto));
            }
            Preconditions.checkNotNull(userDto.getId(), "id不能为空，空的话删个毛");
            UserBo userBo = UserDtoConverter.INSTANCE.convertDtoToInfoBo(userDto);
            Result<Boolean> result = userDomainService.deleteUser(userBo);
            return result;

        } catch (Exception e) {
            log.error("UserController.deleteUser.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/changeStatus")
    public Result<Boolean> changeStatus(@RequestBody UserDto userDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.changeStatus.dto:{}", JSON.toJSONString(userDto));
            }
            Preconditions.checkNotNull(userDto.getId(), "id不能为空，空的话删个毛");
            Preconditions.checkNotNull(userDto.getStatus(), "状态id不能为空，空的话删个毛");
            UserBo userBo = UserDtoConverter.INSTANCE.convertDtoToInfoBo(userDto);
            Result<Boolean> result = userDomainService.changeStatus(userBo);
            return result;

        } catch (Exception e) {
            log.error("UserController.changeStatus.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("/getUserPassword")
    public Result<Boolean> getUserPassword(@RequestBody UserDto userDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.getUserPassword.dto:{}", JSON.toJSONString(userDto));
            }
            Preconditions.checkNotNull(userDto.getUserName(), "用户名称/账号不能为空");
            UserBo userBo = UserDtoConverter.INSTANCE.convertDtoToInfoBo(userDto);
            Result<Boolean> result = userDomainService.getUserPassword(userBo);
            return result;

        } catch (Exception e) {
            log.error("UserController.getUserPassword.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/doLogin")
    public Result<SaTokenInfo> doLogin(@RequestParam("validCode") String validCode) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.doLogin.dto:{}", JSON.toJSONString(validCode));
            }
            Preconditions.checkNotNull(validCode, "验证码不能为空");
            SaTokenInfo saTokenInfo = userDomainService.doLogin(validCode);
            return Result.ok(saTokenInfo);

        } catch (Exception e) {
            log.error("UserController.doLogin.err:{}", e.getMessage());
            return Result.fail("用户登录失败");
        }
    }

    @PostMapping("/getUserInfo")
    public Result<UserDto> getUserInfo(@RequestBody UserDto userDto) {
        try {
            if (log.isInfoEnabled()) {
                log.info("UserController.getUserInfo.dto:{}", JSON.toJSONString(userDto));
            }
            Preconditions.checkNotNull(userDto.getUserName(), "用户名称/账号不能为空");
            UserBo userBo = UserDtoConverter.INSTANCE.convertDtoToInfoBo(userDto);
            UserBo userBo1 = userDomainService.getUserInfo(userBo);
            UserDto userDto1 = new UserDto();
            BeanUtils.copyProperties(userBo1, userDto1);
            return Result.ok(userDto1);

        } catch (Exception e) {
            log.error("UserController.getUserInfo.err:{}", e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/logOut")
    public Result logOut(@RequestParam String userName) {
        try {
            log.info("UserController.logOut.dto:{}", userName);
            Preconditions.checkNotNull(userName, "用户名称/账号不能为空");
            StpUtil.logout(userName);
            return Result.ok("用户登出成功");
        } catch (Exception e) {
            log.error("UserController.logOut.err:{}", e.getMessage());
            return Result.fail("用户登出失败");
        }
    }
}
