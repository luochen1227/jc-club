package com.jingdianjichi.domain.convert;

import com.jingdianjichi.domain.entity.AnswerBo;
import com.jingdianjichi.domain.entity.SubjectOptionBo;
import com.jingdianjichi.subject.infa.basic.entity.Multiple;
import com.jingdianjichi.subject.infa.basic.entity.Radio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MultipeConverter {
    MultipeConverter INSTANCE = Mappers.getMapper(MultipeConverter.class);

    Multiple convertBoToEntity(AnswerBo answerBo);
    List<AnswerBo> convertEntityToBoList(List<Multiple> multiples);

}
