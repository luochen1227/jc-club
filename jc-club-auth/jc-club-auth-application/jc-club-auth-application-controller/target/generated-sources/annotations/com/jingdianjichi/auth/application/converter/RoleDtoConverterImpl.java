package com.jingdianjichi.auth.application.converter;

import com.jingdianjichi.auth.application.dto.RoleDto;
import com.jingdianjichi.auth.domain.bo.RoleBo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T18:46:29+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class RoleDtoConverterImpl implements RoleDtoConverter {

    @Override
    public RoleBo convertDtoToInfoBo(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        RoleBo roleBo = new RoleBo();

        roleBo.setId( roleDto.getId() );
        roleBo.setRoleName( roleDto.getRoleName() );
        roleBo.setRoleKey( roleDto.getRoleKey() );
        roleBo.setIsDeleted( roleDto.getIsDeleted() );

        return roleBo;
    }
}
