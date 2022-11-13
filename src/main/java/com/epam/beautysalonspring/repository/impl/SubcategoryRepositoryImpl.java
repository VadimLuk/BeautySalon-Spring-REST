package com.epam.beautysalonspring.repository.impl;

import com.epam.beautysalonspring.model.Subcategory;
import com.epam.beautysalonspring.repository.SubcategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class SubcategoryRepositoryImpl implements SubcategoryRepository {
    private static HashMap<Long, Subcategory> subcategories = new HashMap<>();
    private Long entityId = 0L;

    @Override
    public List<Subcategory> findByCategory(Long categoryId) {
        log.info("Layer: {}, Getting All Subcategories in Category with ID: {}", this.getClass().getSimpleName(), categoryId);
        return subcategories.values().stream()
                .filter(subcategory -> subcategory.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }

    @Override
    public Subcategory create(Subcategory subcategory) {
        log.info("Layer: {}, Creating Subcategory: {}", this.getClass().getSimpleName(), subcategory);
        subcategory.setId(entityId++);
        subcategories.put(subcategory.getId(), subcategory);
        return subcategories.get(subcategory.getId());
    }

    @Override
    public Subcategory update(Subcategory subcategory) {
        log.info("Layer: {}, Updating Subcategory: {}", this.getClass().getSimpleName(), subcategory);
        subcategories.put(subcategory.getId(), subcategory);
        return subcategories.get(subcategory.getId());
    }

    @Override
    public Subcategory findById(Long id) {
        log.info("Layer: {}, Getting Subcategory with ID: {}", this.getClass().getSimpleName(), id);
        return subcategories.values().stream()
                .filter(subcategory ->
                        subcategory.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
