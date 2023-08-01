package com.epam.beautysalonspring.controller;

import com.epam.beautysalonspring.dto.SalonServiceDto;
import com.epam.beautysalonspring.dto.groups.OnCreate;
import com.epam.beautysalonspring.dto.groups.OnUpdate;
import com.epam.beautysalonspring.service.SalonServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/categories/{categoryId}/subcategories/{subcategoryId}/salon-services")
@RequiredArgsConstructor
public class SalonServiceController {
    private final SalonServiceService salonServiceService;

    @PostMapping
    public SalonServiceDto createSalonService(@RequestBody @Validated(OnCreate.class) SalonServiceDto salonServiceDto) {
        log.info("Layer: {}, Creating SalonService: {}", this.getClass().getSimpleName(), salonServiceDto);
        return salonServiceService.createSalonService(salonServiceDto);
    }

    @PatchMapping("/{id}")
    public SalonServiceDto updateSalonService(@RequestBody @Validated(OnUpdate.class) SalonServiceDto salonServiceDto) {
        log.info("Layer: {}, Updating SalonService: {}", this.getClass().getSimpleName(), salonServiceDto);
        return salonServiceService.updateSalonService(salonServiceDto);
    }

    @GetMapping
    public List<SalonServiceDto> getAllSalonServicesInSubcategory(@PathVariable Long subcategoryId) {
        log.info("Layer: {}, Getting All SalonServices in Subcategory with ID: {}", this.getClass().getSimpleName(), subcategoryId);
        return salonServiceService.getAllSalonServicesInSubcategory(subcategoryId);
    }

    @GetMapping("/{id}")
    public SalonServiceDto getSalonService(@PathVariable Long id) {
        log.info("Layer: {}, Getting SalonService with ID: {}", this.getClass().getSimpleName(), id);
        return salonServiceService.getSalonServiceById(id);
    }
}
