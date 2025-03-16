package com.deep.expensetracker.dto;

import com.deep.expensetracker.entity.Category;

public class CategoryMapper {

    private CategoryDto mapCategoryToCategoryDto(Category category){
        return new CategoryDto(category.getId(), category.getName());
    }

    private Category mapCategoryDtoTOCategory(CategoryDto categoryDto){
        return new Category(categoryDto.id(), categoryDto.name());
    }
}
