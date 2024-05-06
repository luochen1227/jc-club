package com.jingdianjichi.auth.application.converter;

import com.jingdianjichi.auth.application.dto.RoleDto;
import com.jingdianjichi.auth.application.dto.UserDto;
import com.jingdianjichi.auth.domain.bo.RoleBo;
import com.jingdianjichi.auth.domain.bo.UserBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleDtoConverter {
    RoleDtoConverter INSTANCE = Mappers.getMapper(RoleDtoConverter.class);

    RoleBo convertDtoToInfoBo(RoleDto roleDto);
//    List<InfoDto> convertBoToInfoDtoList(List<InfoBo> infoBoList);
//    InfoDto convertBoToInfoDto(InfoBo infoBo);
}
