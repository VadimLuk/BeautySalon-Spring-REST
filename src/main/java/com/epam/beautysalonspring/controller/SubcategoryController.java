package com.epam.beautysalonspring.controller;

import com.epam.beautysalonspring.dto.SubcategoryDto;
import com.epam.beautysalonspring.dto.groups.OnCreate;
import com.epam.beautysalonspring.dto.groups.OnUpdate;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;
import com.epam.beautysalonspring.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/categories/{categoryId}/subcategories")
@RequiredArgsConstructor
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubcategoryDto createSubcategory(@RequestBody @Validated(OnCreate.class) SubcategoryDto subcategoryDto) {
        log.info("Layer: {}, Creating Subcategory: {}", this.getClass().getSimpleName(), subcategoryDto);
        return subcategoryService.createSubcategory(subcategoryDto);
    }

    @PatchMapping("/{id}")
    public SubcategoryDto updateSubcategory(@RequestBody @Validated(OnUpdate.class) SubcategoryDto subcategoryDto) {
        log.info("Layer: {}, Updating Subcategory: {}", this.getClass().getSimpleName(), subcategoryDto);
        return subcategoryService.updateSubcategory(subcategoryDto);
    }

    @GetMapping
    public List<SubcategoryDto> getAllSubcategoriesInCategory(@PathVariable Long categoryId) throws EntityNotFoundException {
        log.info("Layer: {}, Getting All Subcategories in Category with ID: {}", this.getClass().getSimpleName(), categoryId);
        return subcategoryService.getAllSubcategoriesByCategory(categoryId);
    }

    @GetMapping("/{subcategoryId}")
    public SubcategoryDto getSubcategory(@PathVariable Long subcategoryId) throws EntityNotFoundException {
        log.info("Layer: {}, Getting Subcategory with ID: {}", this.getClass().getSimpleName(), subcategoryId);
        return subcategoryService.getSubcategoryById(subcategoryId);
    }
}
