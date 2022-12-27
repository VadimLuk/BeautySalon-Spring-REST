package com.epam.beautysalonspring.service;


import com.epam.beautysalonspring.dto.SalonServiceDto;
import com.epam.beautysalonspring.exceptions.EntityNotFoundException;

import java.util.Set;

public interface SalonServiceService {

    SalonServiceDto createSalonService(SalonServiceDto salonServiceDto);

    SalonServiceDto updateSalonService(SalonServiceDto salonServiceDto);

    Set<SalonServiceDto> getAllSalonServicesInSubcategory(Long subcategoryId) throws EntityNotFoundException;

    SalonServiceDto getSalonServiceById(Long id) throws EntityNotFoundException;
}
