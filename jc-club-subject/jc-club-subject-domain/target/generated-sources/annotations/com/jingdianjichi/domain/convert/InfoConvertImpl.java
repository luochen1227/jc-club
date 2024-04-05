package com.jingdianjichi.domain.convert;

import com.jingdianjichi.domain.entity.AnswerBo;
import com.jingdianjichi.domain.entity.InfoBo;
import com.jingdianjichi.domain.entity.SubjectOptionBo;
import com.jingdianjichi.subject.infa.basic.entity.Info;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-04T16:48:29+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class InfoConvertImpl implements InfoConvert {

    @Override
    public Info convertBoToInfo(InfoBo infoBo) {
        if ( infoBo == null ) {
            return null;
        }

        Info info = new Info();

        info.setId( infoBo.getId() );
        info.setSubjectName( infoBo.getSubjectName() );
        info.setSubjectDifficult( infoBo.getSubjectDifficult() );
        info.setSettleName( infoBo.getSettleName() );
        info.setSubjectType( infoBo.getSubjectType() );
        info.setSubjectScore( infoBo.getSubjectScore() );
        info.setSubjectParse( infoBo.getSubjectParse() );

        return info;
    }

    @Override
    public InfoBo convertOptionToBo(SubjectOptionBo subjectOptionBo) {
        if ( subjectOptionBo == null ) {
            return null;
        }

        InfoBo infoBo = new InfoBo();

        infoBo.setPageNo( subjectOptionBo.getPageNo() );
        infoBo.setPageSize( subjectOptionBo.getPageSize() );
        infoBo.setSubjectAnswer( subjectOptionBo.getSubjectAnswer() );
        List<AnswerBo> list = subjectOptionBo.getOptionList();
        if ( list != null ) {
            infoBo.setOptionList( new ArrayList<AnswerBo>( list ) );
        }

        return infoBo;
    }

    @Override
    public InfoBo convertOptionAndInfoToBo(SubjectOptionBo subjectOptionBo, Info info) {
        if ( subjectOptionBo == null && info == null ) {
            return null;
        }

        InfoBo infoBo = new InfoBo();

        if ( subjectOptionBo != null ) {
            infoBo.setPageNo( subjectOptionBo.getPageNo() );
            infoBo.setPageSize( subjectOptionBo.getPageSize() );
            infoBo.setSubjectAnswer( subjectOptionBo.getSubjectAnswer() );
            List<AnswerBo> list = subjectOptionBo.getOptionList();
            if ( list != null ) {
                infoBo.setOptionList( new ArrayList<AnswerBo>( list ) );
            }
        }
        if ( info != null ) {
            infoBo.setId( info.getId() );
            infoBo.setSubjectName( info.getSubjectName() );
            infoBo.setSubjectDifficult( info.getSubjectDifficult() );
            infoBo.setSettleName( info.getSettleName() );
            infoBo.setSubjectType( info.getSubjectType() );
            infoBo.setSubjectScore( info.getSubjectScore() );
            infoBo.setSubjectParse( info.getSubjectParse() );
        }

        return infoBo;
    }

    @Override
    public List<InfoBo> convertEntityToBo(List<Info> infoList) {
        if ( infoList == null ) {
            return null;
        }

        List<InfoBo> list = new ArrayList<InfoBo>( infoList.size() );
        for ( Info info : infoList ) {
            list.add( infoToInfoBo( info ) );
        }

        return list;
    }

    protected InfoBo infoToInfoBo(Info info) {
        if ( info == null ) {
            return null;
        }

        InfoBo infoBo = new InfoBo();

        infoBo.setId( info.getId() );
        infoBo.setSubjectName( info.getSubjectName() );
        infoBo.setSubjectDifficult( info.getSubjectDifficult() );
        infoBo.setSettleName( info.getSettleName() );
        infoBo.setSubjectType( info.getSubjectType() );
        infoBo.setSubjectScore( info.getSubjectScore() );
        infoBo.setSubjectParse( info.getSubjectParse() );

        return infoBo;
    }
}
