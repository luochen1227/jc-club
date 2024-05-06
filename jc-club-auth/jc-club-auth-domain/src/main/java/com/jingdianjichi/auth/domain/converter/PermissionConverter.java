package com.jingdianjichi.auth.domain.converter;

import com.jingdianjichi.auth.domain.bo.PermissionBo;
import com.jingdianjichi.auth.domain.bo.UserBo;
import com.jingdianjichi.auth.infra.entity.Permission;
import com.jingdianjichi.auth.infra.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionConverter {
    PermissionConverter INSTANCE = Mappers.getMapper(PermissionConverter.class);

    Permission convertBoToEntity(PermissionBo permissionBo);
//    List<InfoDto> convertBoToInfoDtoList(List<InfoBo> infoBoList);
//    InfoDto convertBoToInfoDto(InfoBo infoBo);
}
