package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.bo.PermissionBo;
import com.jingdianjichi.auth.domain.bo.RolePermissionBo;

public interface RolePermissionDomainService {

    Boolean addRolePermission(RolePermissionBo rolePermissionBo);
}
