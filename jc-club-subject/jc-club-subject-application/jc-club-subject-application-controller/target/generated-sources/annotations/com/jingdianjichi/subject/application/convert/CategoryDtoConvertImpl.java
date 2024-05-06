package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.auth.domain.entity.CategoryBo;
import com.jingdianjichi.subject.application.dto.CategoryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-18T16:04:43+0800",
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
        if ( categoryDto.getCount() != null ) {
            categoryBo.setCount( categoryDto.getCount().intValue() );
        }

        return categoryBo;
    }

    @Override
    public CategoryDto convertBoToCategoryDto(CategoryBo categoryBo) {
        if ( categoryBo == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( categoryBo.getId() );
        categoryDto.setCategoryName( categoryBo.getCategoryName() );
        categoryDto.setCategoryType( categoryBo.getCategoryType() );
        categoryDto.setImageUrl( categoryBo.getImageUrl() );
        categoryDto.setParentId( categoryBo.getParentId() );
        if ( categoryBo.getCount() != null ) {
            categoryDto.setCount( categoryBo.getCount().longValue() );
        }

        return categoryDto;
    }

    @Override
    public List<CategoryDto> convertBoToCategoryDtoList(List<CategoryBo> categoryBoList) {
        if ( categoryBoList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categoryBoList.size() );
        for ( CategoryBo categoryBo : categoryBoList ) {
            list.add( convertBoToCategoryDto( categoryBo ) );
        }

        return list;
    }
}
