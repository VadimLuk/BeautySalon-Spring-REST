package com.epam.beautysalonspring.repository;

import com.epam.beautysalonspring.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findCategoryById(Long id);
}
