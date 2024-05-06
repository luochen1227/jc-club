package com.jingdianjichi.auth.domain.service;

import com.jingdianjichi.auth.domain.bo.PermissionBo;

import java.util.List;

public interface PermissionDomainService {
    Boolean addPermission(PermissionBo permissionBo);

    Boolean updatePermission(PermissionBo permissionBo);

    Boolean deletePermission(PermissionBo permissionBo);

    List<String> getPermission(String userName);
}
