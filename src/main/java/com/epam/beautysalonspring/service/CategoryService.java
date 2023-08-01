package com.epam.beautysalonspring.service;


import com.epam.beautysalonspring.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();

    CategoryDto getCategoryById(Long id);

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto);
}
