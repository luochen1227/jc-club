package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.InfoBo;
import com.jingdianjichi.auth.domain.entity.SubjectOptionBo;
import com.jingdianjichi.subject.infa.basic.entity.Info;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InfoConvert {
    InfoConvert INSTANCE = Mappers.getMapper(InfoConvert.class);

    Info convertBoToInfo(InfoBo infoBo);
    InfoBo convertOptionToBo(SubjectOptionBo subjectOptionBo);
    InfoBo convertOptionAndInfoToBo(SubjectOptionBo subjectOptionBo,Info info);
    List<InfoBo> convertEntityToBo(List<Info> infoList);

}
