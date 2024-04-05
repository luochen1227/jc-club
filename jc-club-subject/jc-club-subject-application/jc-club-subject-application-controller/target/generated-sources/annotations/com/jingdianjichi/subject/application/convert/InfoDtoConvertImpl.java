package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.domain.entity.AnswerBo;
import com.jingdianjichi.domain.entity.InfoBo;
import com.jingdianjichi.subject.application.dto.AnswerDto;
import com.jingdianjichi.subject.application.dto.InfoDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T19:22:52+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class InfoDtoConvertImpl implements InfoDtoConvert {

    @Override
    public InfoBo convertDtoToInfoBo(InfoDto infoDto) {
        if ( infoDto == null ) {
            return null;
        }

        InfoBo infoBo = new InfoBo();

        infoBo.setPageNo( infoDto.getPageNo() );
        infoBo.setPageSize( infoDto.getPageSize() );
        infoBo.setId( infoDto.getId() );
        infoBo.setSubjectName( infoDto.getSubjectName() );
        infoBo.setSubjectDifficult( infoDto.getSubjectDifficult() );
        infoBo.setSettleName( infoDto.getSettleName() );
        infoBo.setSubjectType( infoDto.getSubjectType() );
        infoBo.setSubjectScore( infoDto.getSubjectScore() );
        infoBo.setSubjectParse( infoDto.getSubjectParse() );
        infoBo.setSubjectAnswer( infoDto.getSubjectAnswer() );
        List<Integer> list = infoDto.getCategoryIds();
        if ( list != null ) {
            infoBo.setCategoryIds( new ArrayList<Integer>( list ) );
        }
        List<Integer> list1 = infoDto.getLabelIds();
        if ( list1 != null ) {
            infoBo.setLabelIds( new ArrayList<Integer>( list1 ) );
        }
        infoBo.setOptionList( answerDtoListToAnswerBoList( infoDto.getOptionList() ) );
        infoBo.setCategoryId( infoDto.getCategoryId() );
        infoBo.setLabelId( infoDto.getLabelId() );
        List<String> list3 = infoDto.getLabelName();
        if ( list3 != null ) {
            infoBo.setLabelName( new ArrayList<String>( list3 ) );
        }

        return infoBo;
    }

    @Override
    public List<InfoDto> convertBoToInfoDtoList(List<InfoBo> infoBoList) {
        if ( infoBoList == null ) {
            return null;
        }

        List<InfoDto> list = new ArrayList<InfoDto>( infoBoList.size() );
        for ( InfoBo infoBo : infoBoList ) {
            list.add( convertBoToInfoDto( infoBo ) );
        }

        return list;
    }

    @Override
    public InfoDto convertBoToInfoDto(InfoBo infoBo) {
        if ( infoBo == null ) {
            return null;
        }

        InfoDto infoDto = new InfoDto();

        infoDto.setPageNo( infoBo.getPageNo() );
        infoDto.setPageSize( infoBo.getPageSize() );
        infoDto.setId( infoBo.getId() );
        infoDto.setSubjectName( infoBo.getSubjectName() );
        infoDto.setSubjectDifficult( infoBo.getSubjectDifficult() );
        infoDto.setSettleName( infoBo.getSettleName() );
        infoDto.setSubjectType( infoBo.getSubjectType() );
        infoDto.setSubjectScore( infoBo.getSubjectScore() );
        infoDto.setSubjectParse( infoBo.getSubjectParse() );
        infoDto.setSubjectAnswer( infoBo.getSubjectAnswer() );
        List<Integer> list = infoBo.getCategoryIds();
        if ( list != null ) {
            infoDto.setCategoryIds( new ArrayList<Integer>( list ) );
        }
        List<Integer> list1 = infoBo.getLabelIds();
        if ( list1 != null ) {
            infoDto.setLabelIds( new ArrayList<Integer>( list1 ) );
        }
        infoDto.setOptionList( answerBoListToAnswerDtoList( infoBo.getOptionList() ) );
        infoDto.setCategoryId( infoBo.getCategoryId() );
        infoDto.setLabelId( infoBo.getLabelId() );
        List<String> list3 = infoBo.getLabelName();
        if ( list3 != null ) {
            infoDto.setLabelName( new ArrayList<String>( list3 ) );
        }

        return infoDto;
    }

    protected AnswerBo answerDtoToAnswerBo(AnswerDto answerDto) {
        if ( answerDto == null ) {
            return null;
        }

        AnswerBo answerBo = new AnswerBo();

        answerBo.setOptionType( answerDto.getOptionType() );
        answerBo.setOptionContent( answerDto.getOptionContent() );
        answerBo.setIsCorrect( answerDto.getIsCorrect() );

        return answerBo;
    }

    protected List<AnswerBo> answerDtoListToAnswerBoList(List<AnswerDto> list) {
        if ( list == null ) {
            return null;
        }

        List<AnswerBo> list1 = new ArrayList<AnswerBo>( list.size() );
        for ( AnswerDto answerDto : list ) {
            list1.add( answerDtoToAnswerBo( answerDto ) );
        }

        return list1;
    }

    protected AnswerDto answerBoToAnswerDto(AnswerBo answerBo) {
        if ( answerBo == null ) {
            return null;
        }

        AnswerDto answerDto = new AnswerDto();

        answerDto.setOptionType( answerBo.getOptionType() );
        answerDto.setOptionContent( answerBo.getOptionContent() );
        answerDto.setIsCorrect( answerBo.getIsCorrect() );

        return answerDto;
    }

    protected List<AnswerDto> answerBoListToAnswerDtoList(List<AnswerBo> list) {
        if ( list == null ) {
            return null;
        }

        List<AnswerDto> list1 = new ArrayList<AnswerDto>( list.size() );
        for ( AnswerBo answerBo : list ) {
            list1.add( answerBoToAnswerDto( answerBo ) );
        }

        return list1;
    }
}
