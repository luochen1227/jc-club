package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.InfoBo;
import com.jingdianjichi.subject.infa.basic.entity.Brief;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-10T14:33:16+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class BriefConvertImpl implements BriefConvert {

    @Override
    public Brief convertBoToEntity(InfoBo infoBo) {
        if ( infoBo == null ) {
            return null;
        }

        Brief brief = new Brief();

        brief.setId( infoBo.getId() );
        brief.setSubjectAnswer( infoBo.getSubjectAnswer() );

        return brief;
    }
}
