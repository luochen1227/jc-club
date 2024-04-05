package com.jingdianjichi.domain.convert;

import com.jingdianjichi.domain.entity.LabelBo;
import com.jingdianjichi.subject.infa.basic.entity.Label;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-04T16:48:29+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class LabelConvertImpl implements LabelConvert {

    @Override
    public Label convertBoToLabel(LabelBo labelBo) {
        if ( labelBo == null ) {
            return null;
        }

        Label label = new Label();

        label.setId( labelBo.getId() );
        label.setLabelName( labelBo.getLabelName() );
        label.setSortNum( labelBo.getSortNum() );
        label.setCategoryId( labelBo.getCategoryId() );

        return label;
    }

    @Override
    public List<LabelBo> convertEntityToBo(List<Label> labelList) {
        if ( labelList == null ) {
            return null;
        }

        List<LabelBo> list = new ArrayList<LabelBo>( labelList.size() );
        for ( Label label : labelList ) {
            list.add( labelToLabelBo( label ) );
        }

        return list;
    }

    protected LabelBo labelToLabelBo(Label label) {
        if ( label == null ) {
            return null;
        }

        LabelBo labelBo = new LabelBo();

        labelBo.setId( label.getId() );
        labelBo.setLabelName( label.getLabelName() );
        labelBo.setSortNum( label.getSortNum() );
        labelBo.setCategoryId( label.getCategoryId() );

        return labelBo;
    }
}
