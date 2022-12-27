package com.epam.beautysalonspring.service;

import com.epam.beautysalonspring.dto.SubcategoryDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;

import java.util.List;

public interface SubcategoryService {
    SubcategoryDto createSubcategory(SubcategoryDto subcategoryDto);

    SubcategoryDto updateSubcategory(SubcategoryDto subcategoryDto);

    List<SubcategoryDto> getAllSubcategoriesByCategory(Long categoryId) throws EntityNotFoundException;

    SubcategoryDto getSubcategoryById(Long subcategoryId) throws EntityNotFoundException;

}
