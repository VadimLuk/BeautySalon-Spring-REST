package com.epam.beautysalonspring.service;


import com.epam.beautysalonspring.dto.SalonServiceDto;

import java.util.List;

public interface SalonServiceService {

    SalonServiceDto createSalonService(SalonServiceDto salonServiceDto);

    SalonServiceDto updateSalonService(SalonServiceDto salonServiceDto);

    List<SalonServiceDto> getAllSalonServicesInSubcategory(Long subcategoryId);

    SalonServiceDto getSalonServiceById(Long id);
}
