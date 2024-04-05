package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.domain.entity.LabelBo;
import com.jingdianjichi.subject.application.dto.LabelDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-05T15:26:08+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class LabelDtoConvertImpl implements LabelDtoConvert {

    @Override
    public LabelBo convertDtoToLabelBo(LabelDto labelDto) {
        if ( labelDto == null ) {
            return null;
        }

        LabelBo labelBo = new LabelBo();

        labelBo.setId( labelDto.getId() );
        labelBo.setLabelName( labelDto.getLabelName() );
        labelBo.setSortNum( labelDto.getSortNum() );
        labelBo.setCategoryId( labelDto.getCategoryId() );

        return labelBo;
    }

    @Override
    public List<LabelDto> convertBoToCategoryDtoList(List<LabelBo> labelBoList) {
        if ( labelBoList == null ) {
            return null;
        }

        List<LabelDto> list = new ArrayList<LabelDto>( labelBoList.size() );
        for ( LabelBo labelBo : labelBoList ) {
            list.add( labelBoToLabelDto( labelBo ) );
        }

        return list;
    }

    protected LabelDto labelBoToLabelDto(LabelBo labelBo) {
        if ( labelBo == null ) {
            return null;
        }

        LabelDto labelDto = new LabelDto();

        labelDto.setId( labelBo.getId() );
        labelDto.setLabelName( labelBo.getLabelName() );
        labelDto.setSortNum( labelBo.getSortNum() );
        labelDto.setCategoryId( labelBo.getCategoryId() );

        return labelDto;
    }
}
