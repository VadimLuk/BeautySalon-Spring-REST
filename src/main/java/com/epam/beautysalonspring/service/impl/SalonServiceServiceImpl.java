package com.epam.beautysalonspring.service.impl;

import com.epam.beautysalonspring.dto.SalonServiceDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;
import com.epam.beautysalonspring.mapper.SalonServiceMapper;
import com.epam.beautysalonspring.model.SalonService;
import com.epam.beautysalonspring.model.Subcategory;
import com.epam.beautysalonspring.repository.SalonServiceRepository;
import com.epam.beautysalonspring.repository.SubcategoryRepository;
import com.epam.beautysalonspring.service.SalonServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalonServiceServiceImpl implements SalonServiceService {

    private final SubcategoryRepository subcategoryRepository;
    private final SalonServiceRepository salonServiceRepository;
    private final SalonServiceMapper salonServiceMapper;

    @Override
    public SalonServiceDto createSalonService(SalonServiceDto salonServiceDto) {
        log.info("Layer: {}, Creating SalonService: {}", this.getClass().getSimpleName(), salonServiceDto);

        SalonService salonService = salonServiceRepository.save(salonServiceMapper.mapToSalonService(salonServiceDto));
        return salonServiceMapper.mapToSalonServiceDto(salonService);
    }

    @Override
    public SalonServiceDto updateSalonService(SalonServiceDto salonServiceDto) {
        log.info("Layer: {}, Updating SalonService: {}", this.getClass().getSimpleName(), salonServiceDto);

        SalonService salonService = salonServiceRepository.save(salonServiceMapper.mapToSalonService(salonServiceDto));
        return salonServiceMapper.mapToSalonServiceDto(salonService);
    }

    @Override
    public Set<SalonServiceDto> getAllSalonServicesInSubcategory(Long subcategoryId) throws EntityNotFoundException {
        log.info("Layer: {}, Getting All SalonServices in Subcategory with ID: {}", this.getClass().getSimpleName(), subcategoryId);

        Subcategory subcategory = subcategoryRepository.findById(subcategoryId)
                .orElseThrow(() -> new EntityNotFoundException("Subcategory not found"));

        return salonServiceMapper.mapToSalonServiceDtoList(salonServiceRepository.findAllSalonServicesOrBySubcategory(subcategory.getId()));
    }

    @Override
    public SalonServiceDto getSalonServiceById(Long id) throws EntityNotFoundException {
        log.info("Layer: {}, Getting SalonService with ID: {}", this.getClass().getSimpleName(), id);

        SalonService salonService = salonServiceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SalonService not found"));
        return salonServiceMapper.mapToSalonServiceDto(salonService);
    }
}
