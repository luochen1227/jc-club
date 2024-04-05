package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.domain.entity.InfoBo;
import com.jingdianjichi.domain.entity.LabelBo;
import com.jingdianjichi.subject.application.dto.InfoDto;
import com.jingdianjichi.subject.application.dto.LabelDto;
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
