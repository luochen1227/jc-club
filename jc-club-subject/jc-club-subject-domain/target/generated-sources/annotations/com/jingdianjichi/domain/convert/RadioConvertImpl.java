package com.jingdianjichi.domain.convert;

import com.jingdianjichi.domain.entity.AnswerBo;
import com.jingdianjichi.subject.infa.basic.entity.Radio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-06T15:55:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class RadioConvertImpl implements RadioConvert {

    @Override
    public Radio convertBoToEntity(AnswerBo answerBo) {
        if ( answerBo == null ) {
            return null;
        }

        Radio radio = new Radio();

        if ( answerBo.getOptionType() != null ) {
            radio.setOptionType( answerBo.getOptionType().byteValue() );
        }
        radio.setOptionContent( answerBo.getOptionContent() );
        if ( answerBo.getIsCorrect() != null ) {
            radio.setIsCorrect( answerBo.getIsCorrect().byteValue() );
        }

        return radio;
    }

    @Override
    public List<AnswerBo> convertEntityToBoList(List<Radio> radioList) {
        if ( radioList == null ) {
            return null;
        }

        List<AnswerBo> list = new ArrayList<AnswerBo>( radioList.size() );
        for ( Radio radio : radioList ) {
            list.add( radioToAnswerBo( radio ) );
        }

        return list;
    }

    protected AnswerBo radioToAnswerBo(Radio radio) {
        if ( radio == null ) {
            return null;
        }

        AnswerBo answerBo = new AnswerBo();

        if ( radio.getOptionType() != null ) {
            answerBo.setOptionType( radio.getOptionType().intValue() );
        }
        answerBo.setOptionContent( radio.getOptionContent() );
        if ( radio.getIsCorrect() != null ) {
            answerBo.setIsCorrect( radio.getIsCorrect().intValue() );
        }

        return answerBo;
    }
}
