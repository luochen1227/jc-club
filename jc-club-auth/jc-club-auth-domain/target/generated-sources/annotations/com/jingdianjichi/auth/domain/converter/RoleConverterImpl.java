package com.jingdianjichi.auth.domain.converter;

import com.jingdianjichi.auth.domain.bo.RoleBo;
import com.jingdianjichi.auth.infra.entity.Role;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-11T18:46:26+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class RoleConverterImpl implements RoleConverter {

    @Override
    public Role convertBoToEntity(RoleBo roleBo) {
        if ( roleBo == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleBo.getId() );
        role.setRoleName( roleBo.getRoleName() );
        role.setRoleKey( roleBo.getRoleKey() );
        role.setIsDeleted( roleBo.getIsDeleted() );

        return role;
    }
}
