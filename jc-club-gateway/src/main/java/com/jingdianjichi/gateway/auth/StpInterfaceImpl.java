package com.jingdianjichi.gateway.auth;

import cn.dev33.satoken.stp.StpInterface;
import com.alibaba.cloud.commons.lang.StringUtils;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.jingdianjichi.gateway.entity.Permission;
import com.jingdianjichi.gateway.entity.Role;
import com.jingdianjichi.gateway.redis.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private RedisUtil redisUtil;

    private String authPermissionPrefix = "auth.permission";
    private String authRolePrefix = "auth.role";

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return getAuthList(loginId.toString(), authPermissionPrefix);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return getAuthList(loginId.toString(), authRolePrefix);
    }

    private List<String> getAuthList(String loginId, String prefix) {
        String authKey = redisUtil.buildKey(prefix, loginId.toString());
        String authValue = redisUtil.get(authKey);
        if (StringUtils.isBlank(authValue)) {
            return Collections.emptyList();
        }
        List<String> authList = new LinkedList<>();
        if (authRolePrefix.equals(prefix)) {
            List<Role> roleList = new Gson().fromJson(authValue, new TypeToken<List<Role>>() {
            }.getType());
            authList = roleList.stream().map(Role::getRoleKey).collect(Collectors.toList());
        }else if (authPermissionPrefix.equals(prefix)){
            List<Permission> permissionsList = new Gson().fromJson(authValue, new TypeToken<List<Permission>>() {
            }.getType());
            authList = permissionsList.stream().map(Permission::getPermissionKey).collect(Collectors.toList());
        }
        return authList;
    }

}
