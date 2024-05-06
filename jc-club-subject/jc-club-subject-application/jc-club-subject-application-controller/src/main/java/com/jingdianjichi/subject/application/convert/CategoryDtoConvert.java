package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.auth.domain.entity.CategoryBo;
import com.jingdianjichi.subject.application.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryDtoConvert {
    CategoryDtoConvert INSTANCE = Mappers.getMapper(CategoryDtoConvert.class);

    CategoryBo convertDtoToCategoryBo(CategoryDto categoryDto);
    CategoryDto convertBoToCategoryDto(CategoryBo categoryBo);
    List<CategoryDto> convertBoToCategoryDtoList(List<CategoryBo> categoryBoList);


}
