package com.epam.beautysalonspring.service;


import com.epam.beautysalonspring.dto.CategoryDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();

    CategoryDto getCategoryById(Long id) throws EntityNotFoundException;

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto);
}
