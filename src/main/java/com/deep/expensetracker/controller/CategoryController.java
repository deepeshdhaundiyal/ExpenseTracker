package com.deep.expensetracker.controller;

import com.deep.expensetracker.dto.CategoryDto;
import com.deep.expensetracker.service.CategoryService;
import com.deep.expensetracker.service.impl.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
