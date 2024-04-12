package com.jingdianjichi.auth.domain.converter;

import com.jingdianjichi.auth.domain.bo.RoleBo;

import com.jingdianjichi.auth.infra.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleConverter {
    RoleConverter INSTANCE = Mappers.getMapper(RoleConverter.class);

    Role convertBoToEntity(RoleBo roleBo);
//    List<InfoDto> convertBoToInfoDtoList(List<InfoBo> infoBoList);
//    InfoDto convertBoToInfoDto(InfoBo infoBo);
}
