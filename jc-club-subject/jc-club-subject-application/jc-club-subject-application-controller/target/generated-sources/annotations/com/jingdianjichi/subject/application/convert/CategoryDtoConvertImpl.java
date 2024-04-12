package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.auth.domain.entity.CategoryBo;
import com.jingdianjichi.subject.application.dto.CategoryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-10T14:33:19+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class CategoryDtoConvertImpl implements CategoryDtoConvert {

    @Override
    public CategoryBo convertDtoToCategoryBo(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryBo categoryBo = new CategoryBo();

        categoryBo.setId( categoryDto.getId() );
        categoryBo.setCategoryName( categoryDto.getCategoryName() );
        categoryBo.setCategoryType( categoryDto.getCategoryType() );
        categoryBo.setImageUrl( categoryDto.getImageUrl() );
        categoryBo.setParentId( categoryDto.getParentId() );

        return categoryBo;
    }

    @Override
    public List<CategoryDto> convertBoToCategoryDtoList(List<CategoryBo> categoryBoList) {
        if ( categoryBoList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categoryBoList.size() );
        for ( CategoryBo categoryBo : categoryBoList ) {
            list.add( categoryBoToCategoryDto( categoryBo ) );
        }

        return list;
    }

    protected CategoryDto categoryBoToCategoryDto(CategoryBo categoryBo) {
        if ( categoryBo == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( categoryBo.getId() );
        categoryDto.setCategoryName( categoryBo.getCategoryName() );
        categoryDto.setCategoryType( categoryBo.getCategoryType() );
        categoryDto.setImageUrl( categoryBo.getImageUrl() );
        categoryDto.setParentId( categoryBo.getParentId() );

        return categoryDto;
    }
}
