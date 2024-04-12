package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.bo.PermissionBo;

public interface PermissionDomainService {
    Boolean addPermission(PermissionBo permissionBo);

    Boolean updatePermission(PermissionBo permissionBo);

    Boolean deletePermission(PermissionBo permissionBo);
}
