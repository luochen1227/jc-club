package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AnswerBo;
import com.jingdianjichi.subject.infa.basic.entity.Judge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JudgeConvert {
    JudgeConvert INSTANCE = Mappers.getMapper(JudgeConvert.class);

    List<AnswerBo> convertEntityToBoList(List<Judge> judge);

}
