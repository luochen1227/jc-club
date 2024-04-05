package com.jingdianjichi.domain.convert;

import com.jingdianjichi.domain.entity.AnswerBo;
import com.jingdianjichi.domain.entity.JudgeBo;
import com.jingdianjichi.subject.infa.basic.entity.Judge;
import com.jingdianjichi.subject.infa.basic.entity.Radio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface JudgeConvert {
    JudgeConvert INSTANCE = Mappers.getMapper(JudgeConvert.class);

    List<AnswerBo> convertEntityToBoList(List<Judge> judge);

}