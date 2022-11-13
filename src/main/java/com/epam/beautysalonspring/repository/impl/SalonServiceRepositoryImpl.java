package com.epam.beautysalonspring.repository.impl;

import com.epam.beautysalonspring.model.SalonService;
import com.epam.beautysalonspring.model.Subcategory;
import com.epam.beautysalonspring.repository.SalonServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class SalonServiceRepositoryImpl implements SalonServiceRepository {

    private static HashMap<Long, SalonService> salonServices = new HashMap<>();

    private Long entityId = 0L;

    @Override
    public SalonService create(SalonService salonService) {
        log.info("Layer: {}, Creating SalonService: {}", this.getClass().getSimpleName(), salonService);
        salonService.setId(entityId++);
        salonServices.put(salonService.getId(), salonService);
        return salonServices.get(salonService.getId());
    }

    @Override
    public SalonService update(SalonService salonService) {
        log.info("Layer: {}, Updating SalonService: {}", this.getClass().getSimpleName(), salonService);
        salonServices.put(salonService.getId(), salonService);
        return salonServices.get(salonService.getId());
    }

    @Override
    public List<SalonService> findBySubcategory(Long subcategoryId) {
        log.info("Layer: {}, Getting All SalonServices in Subcategory with ID: {}", this.getClass().getSimpleName(), subcategoryId);
        return salonServices.values().stream()
                .filter(salonService -> salonService.getSubcategory().getId().equals(subcategoryId))
                .collect(Collectors.toList());
    }

    @Override
    public SalonService findById(Long id) {
        log.info("Layer: {}, Getting SalonService with ID: {}", this.getClass().getSimpleName(), id);
        return salonServices.get(id);
    }
}
