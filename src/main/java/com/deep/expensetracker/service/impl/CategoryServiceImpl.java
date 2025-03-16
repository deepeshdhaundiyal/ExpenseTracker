package com.deep.expensetracker.service.impl;

import com.deep.expensetracker.dto.CategoryDto;
import com.deep.expensetracker.entity.Category;
import com.deep.expensetracker.mapper.CategoryMapper;
import com.deep.expensetracker.repository.CategoryRepository;
import com.deep.expensetracker.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = CategoryMapper.mapTOCategory(categoryDto);
        Category saveCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(saveCategory);

    }

}
