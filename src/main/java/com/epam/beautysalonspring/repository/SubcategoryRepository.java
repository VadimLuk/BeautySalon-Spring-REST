package com.epam.beautysalonspring.repository;

import com.epam.beautysalonspring.model.Category;
import com.epam.beautysalonspring.model.Subcategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository extends CrudRepository<Subcategory, Long> {
    List<Subcategory> findByCategory(Category category);
}
