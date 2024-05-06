package com.jingdianjichi.auth.application.converter;

import com.jingdianjichi.auth.application.dto.UserDto;
import com.jingdianjichi.auth.domain.bo.UserBo;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserDtoConverter {
    UserDtoConverter INSTANCE = Mappers.getMapper(UserDtoConverter.class);

    UserBo convertDtoToInfoBo(UserDto userDto);
//    List<InfoDto> convertBoToInfoDtoList(List<InfoBo> infoBoList);
//    InfoDto convertBoToInfoDto(InfoBo infoBo);
}
