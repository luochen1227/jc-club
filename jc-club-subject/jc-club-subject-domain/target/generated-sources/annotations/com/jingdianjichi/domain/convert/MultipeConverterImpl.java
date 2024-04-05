package com.jingdianjichi.domain.convert;

import com.jingdianjichi.domain.entity.AnswerBo;
import com.jingdianjichi.subject.infa.basic.entity.Multiple;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T19:22:50+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class MultipeConverterImpl implements MultipeConverter {

    @Override
    public Multiple convertBoToEntity(AnswerBo answerBo) {
        if ( answerBo == null ) {
            return null;
        }

        Multiple multiple = new Multiple();

        if ( answerBo.getOptionType() != null ) {
            multiple.setOptionType( answerBo.getOptionType().longValue() );
        }
        multiple.setOptionContent( answerBo.getOptionContent() );
        if ( answerBo.getIsCorrect() != null ) {
            multiple.setIsCorrect( answerBo.getIsCorrect().byteValue() );
        }

        return multiple;
    }

    @Override
    public List<AnswerBo> convertEntityToBoList(List<Multiple> multiples) {
        if ( multiples == null ) {
            return null;
        }

        List<AnswerBo> list = new ArrayList<AnswerBo>( multiples.size() );
        for ( Multiple multiple : multiples ) {
            list.add( multipleToAnswerBo( multiple ) );
        }

        return list;
    }

    protected AnswerBo multipleToAnswerBo(Multiple multiple) {
        if ( multiple == null ) {
            return null;
        }

        AnswerBo answerBo = new AnswerBo();

        if ( multiple.getOptionType() != null ) {
            answerBo.setOptionType( multiple.getOptionType().intValue() );
        }
        answerBo.setOptionContent( multiple.getOptionContent() );
        if ( multiple.getIsCorrect() != null ) {
            answerBo.setIsCorrect( multiple.getIsCorrect().intValue() );
        }

        return answerBo;
    }
}
