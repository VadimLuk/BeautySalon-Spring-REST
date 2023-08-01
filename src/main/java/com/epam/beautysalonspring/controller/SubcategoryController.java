package com.epam.beautysalonspring.controller;

import com.epam.beautysalonspring.dto.SubcategoryDto;
import com.epam.beautysalonspring.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/categories/{categoryId}/subcategories")
@RequiredArgsConstructor
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @PostMapping
    public SubcategoryDto createSubcategory(@RequestBody SubcategoryDto subcategoryDto) {
        log.info("Layer: {}, Creating Subcategory: {}", this.getClass().getSimpleName(), subcategoryDto);
        return subcategoryService.createSubcategory(subcategoryDto);
    }

    @PutMapping("/{id}")
    public SubcategoryDto updateSubcategory(@RequestBody SubcategoryDto subcategoryDto) {
        log.info("Layer: {}, Updating Subcategory: {}", this.getClass().getSimpleName(), subcategoryDto);
        return subcategoryService.updateSubcategory(subcategoryDto);
    }

    @GetMapping
    public List<SubcategoryDto> getAllSubcategoriesInCategory(@PathVariable Long categoryId) {
        log.info("Layer: {}, Getting All Subcategories in Category with ID: {}", this.getClass().getSimpleName(), categoryId);
        return subcategoryService.getAllSubcategoriesByCategory(categoryId);
    }

    @GetMapping("/{subcategoryId}")
    public SubcategoryDto getSubcategory(@PathVariable Long subcategoryId) {
        log.info("Layer: {}, Getting Subcategory with ID: {}", this.getClass().getSimpleName(), subcategoryId);
        return subcategoryService.getSubcategoryById(subcategoryId);
    }
}
