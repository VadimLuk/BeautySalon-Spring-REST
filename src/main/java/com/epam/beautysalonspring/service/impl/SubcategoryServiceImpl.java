package com.epam.beautysalonspring.service.impl;

import com.epam.beautysalonspring.dto.SubcategoryDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;
import com.epam.beautysalonspring.mapper.SubcategoryMapper;
import com.epam.beautysalonspring.model.Category;
import com.epam.beautysalonspring.model.Subcategory;
import com.epam.beautysalonspring.repository.CategoryRepository;
import com.epam.beautysalonspring.repository.SubcategoryRepository;
import com.epam.beautysalonspring.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class SubcategoryServiceImpl implements SubcategoryService {

    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;
    private final SubcategoryMapper subcategoryMapper;

    @Override
    public SubcategoryDto createSubcategory(SubcategoryDto subcategoryDto) {
        log.info("Layer: {}, Creating Subcategory: {}", this.getClass().getSimpleName(), subcategoryDto);
        Subcategory subcategory = subcategoryRepository.save(subcategoryMapper.mapToSubcategory(subcategoryDto));

        //TODO Maybe add CategoryId, then findCategory and add to SubcategoriesSet

        return subcategoryMapper.mapToSubcategoryDto(subcategory);
    }

    @Override
    public SubcategoryDto updateSubcategory(SubcategoryDto subcategoryDto) {
        log.info("Layer: {}, Updating Subcategory: {}", this.getClass().getSimpleName(), subcategoryDto);

        Subcategory subcategory = subcategoryRepository.save(subcategoryMapper.mapToSubcategory(subcategoryDto));
        return subcategoryMapper.mapToSubcategoryDto(subcategory);
    }

    @Override
    public List<SubcategoryDto> getAllSubcategoriesByCategory(Long categoryId) throws EntityNotFoundException {
        log.info("Layer: {}, Getting All Subcategories in Category with ID: {}", this.getClass().getSimpleName(), categoryId);

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        return subcategoryMapper.mapToSubcategoryDtoList(subcategoryRepository.findByCategory(category));
    }

    @Override
    public SubcategoryDto getSubcategoryById(Long subcategoryId) throws EntityNotFoundException {
        log.info("Layer: {}, Getting Subcategory with ID: {}", this.getClass().getSimpleName(), subcategoryId);
        Subcategory subcategory = subcategoryRepository.findById(subcategoryId)
                .orElseThrow(() -> new EntityNotFoundException("Subcategory not found"));

        return subcategoryMapper.mapToSubcategoryDto(subcategory);
    }
}
