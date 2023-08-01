package com.epam.beautysalonspring.repository;

import com.epam.beautysalonspring.model.SalonService;

import java.util.List;

public interface SalonServiceRepository {
    SalonService create(SalonService salonService);

    SalonService update(SalonService salonService);

    List<SalonService> findBySubcategory(Long subcategoryId);

    SalonService findById(Long id);
}
