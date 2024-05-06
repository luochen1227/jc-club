package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.auth.domain.entity.AnswerBo;
import com.jingdianjichi.subject.application.dto.AnswerDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-18T16:04:43+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
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
