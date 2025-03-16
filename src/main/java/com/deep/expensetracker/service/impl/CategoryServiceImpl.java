package com.deep.expensetracker.service.impl;

import com.deep.expensetracker.dto.CategoryDto;
import com.deep.expensetracker.entity.Category;
import com.deep.expensetracker.mapper.CategoryMapper;
import com.deep.expensetracker.repository.CategoryRepository;
import com.deep.expensetracker.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    @Override
    //method to create categories
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = CategoryMapper.mapTOCategory(categoryDto);
        Category saveCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(saveCategory);

    }

    @Override
    //method to fetch categories with respective category id
    public CategoryDto getCategoryById(long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category with given id not found!!!"));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    //method to fetch all the categories list from the database
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();

        List<CategoryDto> categoryDto = categories.stream()
                .map((category) -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());

        return categoryDto;
    }

    @Override
    //method to update the give category based on id and details
    public CategoryDto updateCategory(long id, CategoryDto categoryDto) {

        //Get details of category from db at given id
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with ID don't exists!!!"));
        category.setName(categoryDto.name());

        Category updatedCategory = categoryRepository.save(category);

        return CategoryMapper.mapToCategoryDto(updatedCategory);
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }
}
