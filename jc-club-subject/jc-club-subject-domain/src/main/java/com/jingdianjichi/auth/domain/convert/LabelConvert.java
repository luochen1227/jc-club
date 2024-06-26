package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.LabelBo;
import com.jingdianjichi.subject.infa.basic.entity.Label;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LabelConvert {
    LabelConvert INSTANCE = Mappers.getMapper(LabelConvert.class);

    Label convertBoToLabel(LabelBo labelBo);
    List<LabelBo> convertEntityToBo(List<Label> labelList);
}
