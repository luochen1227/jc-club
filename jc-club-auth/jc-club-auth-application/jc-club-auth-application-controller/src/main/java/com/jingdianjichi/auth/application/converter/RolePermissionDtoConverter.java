package com.jingdianjichi.auth.application.converter;

import com.jingdianjichi.auth.application.dto.PermissionDto;
import com.jingdianjichi.auth.application.dto.RolePermissionDto;
import com.jingdianjichi.auth.domain.bo.PermissionBo;
import com.jingdianjichi.auth.domain.bo.RolePermissionBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolePermissionDtoConverter {
    RolePermissionDtoConverter INSTANCE = Mappers.getMapper(RolePermissionDtoConverter.class);

    RolePermissionBo convertDtoToInfoBo(RolePermissionDto rolePermissionDto);
//    List<InfoDto> convertBoToInfoDtoList(List<InfoBo> infoBoList);
//    InfoDto convertBoToInfoDto(InfoBo infoBo);
}
