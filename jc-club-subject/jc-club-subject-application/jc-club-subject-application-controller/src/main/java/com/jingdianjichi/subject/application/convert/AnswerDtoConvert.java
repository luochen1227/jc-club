package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.auth.domain.entity.AnswerBo;
import com.jingdianjichi.subject.application.dto.AnswerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AnswerDtoConvert {
    AnswerDtoConvert INSTANCE = Mappers.getMapper(AnswerDtoConvert.class);

    AnswerBo convertDtoToAnswerBo(AnswerDto answerDto);
    List<AnswerBo> convertDtoToAnswerBoList(List<AnswerDto> answerDto);
}
