package com.epam.beautysalonspring.mapper;

import com.epam.beautysalonspring.dto.SalonServiceDto;
import com.epam.beautysalonspring.model.SalonService;
import org.mapstruct.*;

import java.util.Set;


@Mapper(
        componentModel = "spring"
)
public interface SalonServiceMapper {
    SalonService mapToSalonService(SalonServiceDto salonServiceDto);

    @Mapping(target = "subcategoryId", source = "subcategory.id")
    SalonServiceDto mapToSalonServiceDto(SalonService salonService);

    Set<SalonServiceDto> mapToSalonServiceDtoList(Set<SalonService> salonServices);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSalonServiceFromSalonServiceDto(SalonServiceDto salonServiceDto, @MappingTarget SalonService salonService);
}
