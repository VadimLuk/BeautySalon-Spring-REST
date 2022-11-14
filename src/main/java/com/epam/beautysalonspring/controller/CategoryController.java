package com.epam.beautysalonspring.controller;

import com.epam.beautysalonspring.dto.CategoryDto;
import com.epam.beautysalonspring.dto.groups.OnCreate;
import com.epam.beautysalonspring.dto.groups.OnUpdate;
import com.epam.beautysalonspring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryDto createCategory(@RequestBody @Validated(OnCreate.class) CategoryDto categoryDto) {
        log.info("Layer: {}, Creating Category: {}", this.getClass().getSimpleName(), categoryDto);
        return categoryService.createCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public CategoryDto updateCategory(@RequestBody @Validated(OnUpdate.class) CategoryDto categoryDto) {
        log.info("Layer: {}, Updating Category: {}", this.getClass().getSimpleName(), categoryDto);
        return categoryService.updateCategory(categoryDto);
    }

    @GetMapping
    public List<CategoryDto> getCategories() {
        log.info("Layer: {}, Getting All Categories", this.getClass().getSimpleName());
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable Long id) {
        log.info("Layer: {}, Getting Category with ID: {}", this.getClass().getSimpleName(), id);
        return categoryService.getCategoryById(id);
    }

}
