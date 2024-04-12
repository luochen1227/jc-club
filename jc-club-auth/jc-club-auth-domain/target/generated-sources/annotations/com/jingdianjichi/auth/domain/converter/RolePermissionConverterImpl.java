package com.jingdianjichi.auth.domain.converter;

import com.jingdianjichi.auth.domain.bo.RolePermissionBo;
import com.jingdianjichi.auth.infra.entity.RolePermission;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T18:46:26+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class RolePermissionConverterImpl implements RolePermissionConverter {

    @Override
    public RolePermission convertBoToEntity(RolePermissionBo rolePermissionBo) {
        if ( rolePermissionBo == null ) {
            return null;
        }

        RolePermission rolePermission = new RolePermission();

        rolePermission.setId( rolePermissionBo.getId() );
        rolePermission.setRoleId( rolePermissionBo.getRoleId() );
        rolePermission.setPermissionId( rolePermissionBo.getPermissionId() );
        rolePermission.setIsDeleted( rolePermissionBo.getIsDeleted() );

        return rolePermission;
    }
}
