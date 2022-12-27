package com.epam.beautysalonspring.service.impl;

import com.epam.beautysalonspring.dto.CategoryDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;
import com.epam.beautysalonspring.mapper.CategoryMapper;
import com.epam.beautysalonspring.model.Category;
import com.epam.beautysalonspring.repository.CategoryRepository;
import com.epam.beautysalonspring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        log.info("Layer: {}, Creating Category: {}", this.getClass().getSimpleName(), categoryDto);

        Category category = categoryRepository.save(categoryMapper.mapToCategory(categoryDto));
        return categoryMapper.mapToCategoryDto(category);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        log.info("Layer: {}, Updating Category: {}", this.getClass().getSimpleName(), categoryDto);

        Category category = categoryRepository.save(categoryMapper.mapToCategory(categoryDto));
        return categoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getCategories() {
        log.info("Layer: {}, Getting All Categories", this.getClass().getSimpleName());

        return categoryMapper.mapToCategoryDtoList((List<Category>) categoryRepository.findAll());
    }

    @Override
    public CategoryDto getCategoryById(Long id) throws EntityNotFoundException {
        log.info("Layer: {}, Getting Category with ID: {}", this.getClass().getSimpleName(), id);

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        return categoryMapper.mapToCategoryDto(category);
    }
}
