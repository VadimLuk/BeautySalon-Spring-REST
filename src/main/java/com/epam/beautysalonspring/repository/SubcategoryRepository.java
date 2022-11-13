package com.epam.beautysalonspring.repository;

import com.epam.beautysalonspring.model.Subcategory;

import java.util.List;

public interface SubcategoryRepository {
    List<Subcategory> findByCategory(Long categoryId);

    Subcategory create(Subcategory mapToSubcategory);

    Subcategory update(Subcategory mapToSubcategory);

    Subcategory findById(Long subcategoryId);
}
