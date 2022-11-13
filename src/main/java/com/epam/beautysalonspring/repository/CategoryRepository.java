package com.epam.beautysalonspring.repository;

import com.epam.beautysalonspring.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();

    Category create(Category category);

    Category update(Category category);

    Category findById(Long id);
}
