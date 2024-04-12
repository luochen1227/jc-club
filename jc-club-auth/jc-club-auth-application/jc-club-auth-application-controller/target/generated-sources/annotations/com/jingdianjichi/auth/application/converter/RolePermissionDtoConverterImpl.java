package com.jingdianjichi.auth.application.converter;

import com.jingdianjichi.auth.application.dto.RolePermissionDto;
import com.jingdianjichi.auth.domain.bo.RolePermissionBo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T18:46:29+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class RolePermissionDtoConverterImpl implements RolePermissionDtoConverter {

    @Override
    public RolePermissionBo convertDtoToInfoBo(RolePermissionDto rolePermissionDto) {
        if ( rolePermissionDto == null ) {
            return null;
        }

        RolePermissionBo rolePermissionBo = new RolePermissionBo();

        rolePermissionBo.setId( rolePermissionDto.getId() );
        rolePermissionBo.setRoleId( rolePermissionDto.getRoleId() );
        rolePermissionBo.setPermissionId( rolePermissionDto.getPermissionId() );
        List<Long> list = rolePermissionDto.getPermissionIdList();
        if ( list != null ) {
            rolePermissionBo.setPermissionIdList( new ArrayList<Long>( list ) );
        }
        rolePermissionBo.setIsDeleted( rolePermissionDto.getIsDeleted() );

        return rolePermissionBo;
    }
}
