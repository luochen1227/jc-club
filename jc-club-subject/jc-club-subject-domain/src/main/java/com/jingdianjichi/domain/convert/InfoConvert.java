package com.jingdianjichi.domain.convert;

import com.jingdianjichi.domain.entity.InfoBo;
import com.jingdianjichi.domain.entity.LabelBo;
import com.jingdianjichi.domain.entity.SubjectOptionBo;
import com.jingdianjichi.subject.infa.basic.entity.Info;
import com.jingdianjichi.subject.infa.basic.entity.Label;
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