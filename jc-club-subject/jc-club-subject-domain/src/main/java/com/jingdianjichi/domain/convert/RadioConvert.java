package com.jingdianjichi.domain.convert;

import com.jingdianjichi.domain.entity.AnswerBo;
import com.jingdianjichi.subject.infa.basic.entity.Radio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RadioConvert {
    RadioConvert INSTANCE = Mappers.getMapper(RadioConvert.class);

    Radio convertBoToEntity(AnswerBo answerBo);
    List<AnswerBo> convertEntityToBoList(List<Radio> radioList);

}
