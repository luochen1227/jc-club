package com.jingdianjichi.auth.domain.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.jingdianjichi.auth.domain.bo.UserBo;
import com.jingdianjichi.entity.Result;

public interface UserDomainService {
    Boolean registerUser(UserBo userBo);

    int updateUser(UserBo userBo);

    Result<Boolean> deleteUser(UserBo userBo);

    Result<Boolean> changeStatus(UserBo userBo);

    Result<Boolean> getUserPassword(UserBo userBo);

    SaTokenInfo doLogin(String validCode);

    UserBo getUserInfo(UserBo userBo);
}
