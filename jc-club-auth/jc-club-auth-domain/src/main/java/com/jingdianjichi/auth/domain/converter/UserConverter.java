package com.jingdianjichi.auth.domain.converter;

import com.jingdianjichi.auth.domain.bo.UserBo;
import com.jingdianjichi.auth.infra.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    User convertBoToEntity(UserBo userBo);
//    List<InfoDto> convertBoToInfoDtoList(List<InfoBo> infoBoList);
//    InfoDto convertBoToInfoDto(InfoBo infoBo);
}
