package com.jingdianjichi.auth.application.converter;

import com.jingdianjichi.auth.application.dto.PermissionDto;
import com.jingdianjichi.auth.application.dto.RoleDto;
import com.jingdianjichi.auth.domain.bo.PermissionBo;
import com.jingdianjichi.auth.domain.bo.RoleBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionDtoConverter {
    PermissionDtoConverter INSTANCE = Mappers.getMapper(PermissionDtoConverter.class);

    PermissionBo convertDtoToInfoBo(PermissionDto permissionDto);
//    List<InfoDto> convertBoToInfoDtoList(List<InfoBo> infoBoList);
//    InfoDto convertBoToInfoDto(InfoBo infoBo);
}
