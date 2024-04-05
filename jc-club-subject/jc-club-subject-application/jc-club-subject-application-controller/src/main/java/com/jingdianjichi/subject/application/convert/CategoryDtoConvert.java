package com.jingdianjichi.subject.application.convert;

import com.jingdianjichi.domain.entity.CategoryBo;
import com.jingdianjichi.subject.application.dto.CategoryDto;
import com.jingdianjichi.subject.infa.basic.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryDtoConvert {
    CategoryDtoConvert INSTANCE = Mappers.getMapper(CategoryDtoConvert.class);

    CategoryBo convertDtoToCategoryBo(CategoryDto categoryDto);
    List<CategoryDto> convertBoToCategoryDtoList(List<CategoryBo> categoryBoList);
}
