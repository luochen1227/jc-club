package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.auth.domain.entity.InfoBo;
import com.jingdianjichi.subject.application.dto.InfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InfoDtoConvert {
    InfoDtoConvert INSTANCE = Mappers.getMapper(InfoDtoConvert.class);

    InfoBo convertDtoToInfoBo(InfoDto infoDto);
    List<InfoDto> convertBoToInfoDtoList(List<InfoBo> infoBoList);
    InfoDto convertBoToInfoDto(InfoBo infoBo);
}
