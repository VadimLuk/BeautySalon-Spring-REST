package com.epam.beautysalonspring.service;

import com.epam.beautysalonspring.dto.SubcategoryDto;

import java.util.List;

public interface SubcategoryService {
    SubcategoryDto createSubcategory(SubcategoryDto subcategoryDto);

    SubcategoryDto updateSubcategory(SubcategoryDto subcategoryDto);

    List<SubcategoryDto> getAllSubcategoriesByCategory(Long categoryId);

    SubcategoryDto getSubcategoryById(Long subcategoryId);

}
