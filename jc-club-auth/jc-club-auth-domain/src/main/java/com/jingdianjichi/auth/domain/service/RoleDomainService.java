package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.bo.RoleBo;
import com.jingdianjichi.auth.domain.bo.UserBo;
import com.jingdianjichi.entity.Result;

public interface RoleDomainService {

    Boolean addRole(RoleBo roleBo);

    Boolean updateRole(RoleBo roleBo);

    Boolean deleteRoleById(RoleBo roleBo);
}
