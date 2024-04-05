package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.domain.entity.AnswerBo;
import com.jingdianjichi.subject.application.dto.AnswerDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T15:26:08+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class AnswerDtoConvertImpl implements AnswerDtoConvert {

    @Override
    public AnswerBo convertDtoToAnswerBo(AnswerDto answerDto) {
        if ( answerDto == null ) {
            return null;
        }

        AnswerBo answerBo = new AnswerBo();

        answerBo.setOptionType( answerDto.getOptionType() );
        answerBo.setOptionContent( answerDto.getOptionContent() );
        answerBo.setIsCorrect( answerDto.getIsCorrect() );

        return answerBo;
    }

    @Override
    public List<AnswerBo> convertDtoToAnswerBoList(List<AnswerDto> answerDto) {
        if ( answerDto == null ) {
            return null;
        }

        List<AnswerBo> list = new ArrayList<AnswerBo>( answerDto.size() );
        for ( AnswerDto answerDto1 : answerDto ) {
            list.add( convertDtoToAnswerBo( answerDto1 ) );
        }

        return list;
    }
}
