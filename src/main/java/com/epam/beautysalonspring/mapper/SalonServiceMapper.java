package com.epam.beautysalonspring.mapper;

import com.epam.beautysalonspring.dto.SalonServiceDto;
import com.epam.beautysalonspring.model.SalonService;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface SalonServiceMapper {
    SalonService mapToSalonService(SalonServiceDto salonServiceDto);

    SalonServiceDto mapToSalonServiceDto(SalonService salonService);

    List<SalonServiceDto> mapToSalonServiceDtoList(List<SalonService> salonServices);
}
