package com.deep.expensetracker.mapper;

import com.deep.expensetracker.dto.CategoryDto;
import com.deep.expensetracker.entity.Category;
import lombok.Data;

@Data
public class CategoryMapper {

    public static Category mapTOCategory(CategoryDto categoryDto){
        Category category = new Category(categoryDto.id(), categoryDto.name());
        return category;
    }

    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(category.getId(), category.getName());
    }

}
