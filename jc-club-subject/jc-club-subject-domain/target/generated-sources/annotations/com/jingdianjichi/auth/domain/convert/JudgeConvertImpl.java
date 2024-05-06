package com.jingdianjichi.auth.domain.convert;

import com.jingdianjichi.auth.domain.entity.AnswerBo;
import com.jingdianjichi.subject.infa.basic.entity.Judge;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-18T16:04:41+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class JudgeConvertImpl implements JudgeConvert {

    @Override
    public List<AnswerBo> convertEntityToBoList(List<Judge> judge) {
        if ( judge == null ) {
            return null;
        }

        List<AnswerBo> list = new ArrayList<AnswerBo>( judge.size() );
        for ( Judge judge1 : judge ) {
            list.add( judgeToAnswerBo( judge1 ) );
        }

        return list;
    }

    protected AnswerBo judgeToAnswerBo(Judge judge) {
        if ( judge == null ) {
            return null;
        }

        AnswerBo answerBo = new AnswerBo();

        answerBo.setIsCorrect( judge.getIsCorrect() );

        return answerBo;
    }
}
