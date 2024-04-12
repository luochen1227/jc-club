package com.jingdianjichi.auth.domain.converter;

import com.jingdianjichi.auth.domain.bo.PermissionBo;
import com.jingdianjichi.auth.infra.entity.Permission;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T18:46:26+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class PermissionConverterImpl implements PermissionConverter {

    @Override
    public Permission convertBoToEntity(PermissionBo permissionBo) {
        if ( permissionBo == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setId( permissionBo.getId() );
        permission.setName( permissionBo.getName() );
        permission.setParentId( permissionBo.getParentId() );
        permission.setType( permissionBo.getType() );
        permission.setMenuUrl( permissionBo.getMenuUrl() );
        permission.setStatus( permissionBo.getStatus() );
        permission.setShow( permissionBo.getShow() );
        permission.setIcon( permissionBo.getIcon() );
        permission.setPermissionKey( permissionBo.getPermissionKey() );
        permission.setIsDeleted( permissionBo.getIsDeleted() );

        return permission;
    }
}
