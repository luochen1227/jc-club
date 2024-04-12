package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.auth.domain.entity.LabelBo;
import com.jingdianjichi.subject.application.dto.LabelDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LabelDtoConvert {
    LabelDtoConvert INSTANCE = Mappers.getMapper(LabelDtoConvert.class);

    LabelBo convertDtoToLabelBo(LabelDto labelDto);
    List<LabelDto> convertBoToCategoryDtoList(List<LabelBo> labelBoList);
}
