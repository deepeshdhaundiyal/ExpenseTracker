package com.deep.expensetracker.controller;

import com.deep.expensetracker.dto.CategoryDto;
import com.deep.expensetracker.service.CategoryService;
import com.deep.expensetracker.service.impl.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/category")
public class CategoryController {

    private CategoryService categoryService;

    //Rest API to create a category
    @PostMapping("/create")
    private ResponseEntity<CategoryDto> createCategory(
            @RequestBody CategoryDto categoryDto){
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category,HttpStatus.CREATED);
    }

    //Rest API to get category by id
    @GetMapping("/{id}")
    private ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") long categoryId){
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    //Rest API to get all the categories
    @GetMapping("/categories")
    private ResponseEntity<List<CategoryDto>> getAllCategoreis(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    //Rest API to update a category by id
    @PutMapping("/update/{id}")
    private ResponseEntity<CategoryDto> updateCategory(@PathVariable long id, @RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.updateCategory(id,categoryDto));
    }
}
