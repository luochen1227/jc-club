package com.jingdianjichi.auth.domain.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.gson.Gson;
import com.jingdianjichi.auth.domain.bo.UserBo;
import com.jingdianjichi.auth.domain.constants.AuthConstant;
import com.jingdianjichi.auth.domain.converter.UserConverter;
import com.jingdianjichi.auth.domain.redis.RedisUtil;
import com.jingdianjichi.auth.domain.service.UserDomainService;
import com.jingdianjichi.auth.infra.entity.*;
import com.jingdianjichi.auth.infra.mapper.*;
import com.jingdianjichi.auth.infra.service.IUserService;
import com.jingdianjichi.entity.Result;
import com.jingdianjichi.enums.IsDeletedFlagEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserDomainServiceImpl implements UserDomainService {
    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";
    private String authRolePrefix = "auth.role";
    @Resource
    private UserMapper userMapper;
    @Resource
    private IUserService userService;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    @Resource
    private PermissionMapper permissionMapper;

    public Boolean registerUser(UserBo userBo) {
        if (log.isInfoEnabled()) {
            log.info("UserDomainServiceImpl.registerUser.bo:{}", JSON.toJSONString(userBo));
        }
        User user = UserConverter.INSTANCE.convertBoToEntity(userBo);
        user.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        String password = user.getPassword();
        String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(pw_hash);
        user.setStatus(0);
        int insert = userMapper.insert(user);
        Role role = new Role();
        role.setRoleKey(AuthConstant.NORMAL_USER);
        LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        roleLambdaQueryWrapper.eq(Role::getRoleKey,role.getRoleKey());
        Role role1 = roleMapper.selectOne(roleLambdaQueryWrapper);
        Long roleId = role1.getId();
        Long userId = user.getId();
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        userRole.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        userRoleMapper.insert(userRole);

        String roleKey = redisUtil.buildKey(authRolePrefix, user.getUserName());
        LinkedList<Role> roles = new LinkedList<>();
        roles.add(role);
        redisUtil.set(roleKey,new Gson().toJson(roles));

        LambdaQueryWrapper<RolePermission> roleLambdaQueryWrapper1 = new LambdaQueryWrapper<>();
        roleLambdaQueryWrapper1.eq(RolePermission::getRoleId,roleId);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectList(roleLambdaQueryWrapper1);
        List<Long> permissionIdList = rolePermissions.stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
        //根据roleIdList查权限
        List<Permission> permissionList = permissionMapper.selectBatchIds(permissionIdList);
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, user.getUserName());
        redisUtil.set(permissionKey, new Gson().toJson(permissionList));

        return insert > 0;
    }

    @Override
    public int updateUser(UserBo userBo) {
        if (log.isInfoEnabled()) {
            log.info("UserDomainServiceImpl.registerUser.bo:{}", JSON.toJSONString(userBo));
        }
        User user = UserConverter.INSTANCE.convertBoToEntity(userBo);
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUserName,user.getUserName());
        int update = userMapper.update(user,userLambdaQueryWrapper);
        return update;
    }

    @Override
    public Result<Boolean> deleteUser(UserBo userBo) {
        if (log.isInfoEnabled()) {
            log.info("UserDomainServiceImpl.deleteUser.bo:{}", JSON.toJSONString(userBo));
        }
        User user = UserConverter.INSTANCE.convertBoToEntity(userBo);
        int i = userMapper.deleteById(user.getId());
        if (i != 0) {
            return Result.ok(true, "恭喜你，删除成功");
        }
        return Result.fail(false, "删除失败");
    }

    @Override
    public Result<Boolean> changeStatus(UserBo userBo) {
        if (log.isInfoEnabled()) {
            log.info("UserDomainServiceImpl.changeStatus.bo:{}", JSON.toJSONString(userBo));
        }
        User user = UserConverter.INSTANCE.convertBoToEntity(userBo);
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getId,user.getId());
        int i = userMapper.update(user,userLambdaQueryWrapper);
        if (i != 0) {
            return Result.ok(true, "恭喜你，状态装换成功");
        }
        return Result.fail(false, "状态装换失败");
    }
    /**
     * @description  验证BCrypt加密
     * @param userBo
     * @return Result<Boolean>
     * @date 2024/4/10 15:32
     * @author 坤
     */

    @Override
    public Result<Boolean> getUserPassword(UserBo userBo) {
        if (log.isInfoEnabled()) {
            log.info("UserDomainServiceImpl.changeStatus.bo:{}", JSON.toJSONString(userBo));
        }
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        User user = UserConverter.INSTANCE.convertBoToEntity(userBo);
        userLambdaQueryWrapper.eq(User::getUserName,user.getUserName());
        User user1 = userMapper.selectOne(userLambdaQueryWrapper);
        String password = user1.getPassword();
        // 使用checkpw方法检查被加密的字符串是否与原始字符串匹配：
        boolean checkpw = BCrypt.checkpw( userBo.getPassword(),password);
        if (checkpw == true) {
            return Result.ok(true, "恭喜你，密码正确");
        }
        return Result.fail(false, "密码错误");
    }


}
