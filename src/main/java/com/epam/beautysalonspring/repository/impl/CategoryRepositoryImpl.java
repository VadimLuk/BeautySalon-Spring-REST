package com.epam.beautysalonspring.repository.impl;

import com.epam.beautysalonspring.model.Category;
import com.epam.beautysalonspring.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private static HashMap<Long, Category> categories = new HashMap<>();
    private Long entityId = 0L;


    @Override
    public List<Category> findAll() {
        log.info("Layer: {}, Getting All Categories", this.getClass().getSimpleName());
        return new ArrayList<>(categories.values());
    }

    @Override
    public Category create(Category category) {
        log.info("Layer: {}, Creating Category: {}", this.getClass().getSimpleName(), category);
        category.setId(entityId++);
        categories.put(category.getId(), category);
        return categories.get(category.getId());
    }

    @Override
    public Category update(Category category) {
        log.info("Layer: {}, Updating Category: {}", this.getClass().getSimpleName(), category);
        categories.put(category.getId(), category);
        return categories.get(category.getId());
    }

    @Override
    public Category findById(Long id) {
        log.info("Layer: {}, Getting Category with ID: {}", this.getClass().getSimpleName(), id);
        return categories.values().stream()
                .filter(category ->
                        category.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
