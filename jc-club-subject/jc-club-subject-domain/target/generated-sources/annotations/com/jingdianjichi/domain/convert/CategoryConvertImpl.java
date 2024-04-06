package com.jingdianjichi.domain.convert;

import com.jingdianjichi.domain.entity.CategoryBo;
import com.jingdianjichi.subject.infa.basic.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-06T15:55:10+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class CategoryConvertImpl implements CategoryConvert {

    @Override
    public Category convertBoToCategory(CategoryBo categoryBo) {
        if ( categoryBo == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryBo.getId() );
        category.setCategoryName( categoryBo.getCategoryName() );
        category.setCategoryType( categoryBo.getCategoryType() );
        category.setImageUrl( categoryBo.getImageUrl() );
        category.setParentId( categoryBo.getParentId() );

        return category;
    }

    @Override
    public List<CategoryBo> convertEntityToBo(List<Category> categoryList) {
        if ( categoryList == null ) {
            return null;
        }

        List<CategoryBo> list = new ArrayList<CategoryBo>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add( categoryToCategoryBo( category ) );
        }

        return list;
    }

    protected CategoryBo categoryToCategoryBo(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryBo categoryBo = new CategoryBo();

        categoryBo.setId( category.getId() );
        categoryBo.setCategoryName( category.getCategoryName() );
        categoryBo.setCategoryType( category.getCategoryType() );
        categoryBo.setImageUrl( category.getImageUrl() );
        categoryBo.setParentId( category.getParentId() );

        return categoryBo;
    }
}
