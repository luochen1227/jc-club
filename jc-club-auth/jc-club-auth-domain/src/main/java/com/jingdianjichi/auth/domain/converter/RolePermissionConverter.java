package com.jingdianjichi.auth.domain.converter;

import com.jingdianjichi.auth.domain.bo.PermissionBo;
import com.jingdianjichi.auth.domain.bo.RolePermissionBo;
import com.jingdianjichi.auth.infra.entity.Permission;
import com.jingdianjichi.auth.infra.entity.RolePermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolePermissionConverter {
    RolePermissionConverter INSTANCE = Mappers.getMapper(RolePermissionConverter.class);

    RolePermission convertBoToEntity(RolePermissionBo rolePermissionBo);
//    List<InfoDto> convertBoToInfoDtoList(List<InfoBo> infoBoList);
//    InfoDto convertBoToInfoDto(InfoBo infoBo);
}
