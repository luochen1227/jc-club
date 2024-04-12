package com.jingdianjichi.auth.application.converter;

import com.jingdianjichi.auth.application.dto.PermissionDto;
import com.jingdianjichi.auth.domain.bo.PermissionBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T18:46:29+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class PermissionDtoConverterImpl implements PermissionDtoConverter {

    @Override
    public PermissionBo convertDtoToInfoBo(PermissionDto permissionDto) {
        if ( permissionDto == null ) {
            return null;
        }

        PermissionBo permissionBo = new PermissionBo();

        permissionBo.setId( permissionDto.getId() );
        permissionBo.setName( permissionDto.getName() );
        permissionBo.setParentId( permissionDto.getParentId() );
        permissionBo.setType( permissionDto.getType() );
        permissionBo.setMenuUrl( permissionDto.getMenuUrl() );
        permissionBo.setStatus( permissionDto.getStatus() );
        permissionBo.setShow( permissionDto.getShow() );
        permissionBo.setIcon( permissionDto.getIcon() );
        permissionBo.setPermissionKey( permissionDto.getPermissionKey() );
        permissionBo.setIsDeleted( permissionDto.getIsDeleted() );

        return permissionBo;
    }
}
