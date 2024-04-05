package com.jingdianjichi.domain.convert;

import com.jingdianjichi.domain.entity.CategoryBo;
import com.jingdianjichi.subject.infa.basic.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryConvert {
    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);

    Category convertBoToCategory(CategoryBo categoryBo);
    List<CategoryBo> convertEntityToBo(List<Category> categoryList);
}
