package com.deep.expensetracker.service;

import com.deep.expensetracker.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(long categoryId);

    List<CategoryDto> getAllCategory();

}
