package com.epam.beautysalonspring.service.impl;

import com.epam.beautysalonspring.dto.SalonServiceDto;
import com.epam.beautysalonspring.mapper.SalonServiceMapper;
import com.epam.beautysalonspring.model.SalonService;
import com.epam.beautysalonspring.repository.SalonServiceRepository;
import com.epam.beautysalonspring.service.SalonServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalonServiceServiceImpl implements SalonServiceService {

    private final SalonServiceRepository salonServiceRepository;
    private final SalonServiceMapper salonServiceMapper;

    @Override
    public SalonServiceDto createSalonService(SalonServiceDto salonServiceDto) {
        log.info("Layer: {}, Creating SalonService: {}", this.getClass().getSimpleName(), salonServiceDto);
        SalonService salonService = salonServiceRepository.create(salonServiceMapper.mapToSalonService(salonServiceDto));
        return salonServiceMapper.mapToSalonServiceDto(salonService);
    }

    @Override
    public SalonServiceDto updateSalonService(SalonServiceDto salonServiceDto) {
        log.info("Layer: {}, Updating SalonService: {}", this.getClass().getSimpleName(), salonServiceDto);
        SalonService salonService = salonServiceRepository.update(salonServiceMapper.mapToSalonService(salonServiceDto));
        return salonServiceMapper.mapToSalonServiceDto(salonService);
    }

    @Override
    public List<SalonServiceDto> getAllSalonServicesInSubcategory(Long subcategoryId) {
        log.info("Layer: {}, Getting All SalonServices in Subcategory with ID: {}", this.getClass().getSimpleName(), subcategoryId);
        return salonServiceMapper.mapToSalonServiceDtoList(salonServiceRepository.findBySubcategory(subcategoryId));
    }

    @Override
    public SalonServiceDto getSalonServiceById(Long id) {
        log.info("Layer: {}, Getting SalonService with ID: {}", this.getClass().getSimpleName(), id);
        return salonServiceMapper.mapToSalonServiceDto(salonServiceRepository.findById(id));
    }
}
