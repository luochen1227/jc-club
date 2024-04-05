package com.jingdianjichi.domain.convert;


import com.jingdianjichi.domain.entity.InfoBo;
import com.jingdianjichi.subject.infa.basic.entity.Brief;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BriefConvert {
    BriefConvert INSTANCE = Mappers.getMapper(BriefConvert.class);

    Brief convertBoToEntity(InfoBo infoBo);

}
