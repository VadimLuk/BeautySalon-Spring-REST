package com.epam.beautysalonspring.mapper;

import com.epam.beautysalonspring.dto.AppointmentDto;
import com.epam.beautysalonspring.model.Appointment;
import com.epam.beautysalonspring.repository.SalonServiceRepository;
import com.epam.beautysalonspring.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(
        componentModel = "spring",
        uses = {
                EnumMapper.class,
                UserRepository.class,
                SalonServiceRepository.class
        }
)
public interface AppointmentMapper {

    @Mappings({
            @Mapping(target = "status", source = "status", qualifiedByName = "toEnumCase"),
            @Mapping(target = "master", source = "masterId"),
            @Mapping(target = "client", source = "clientId"),
            @Mapping(target = "salonService", source = "salonServiceId")
    })
    Appointment mapToAppointment(AppointmentDto appointmentDto);

    AppointmentDto mapToAppointmentDto(Appointment appointment);

    List<AppointmentDto> mapToAppointmentDtoList(List<Appointment> appointments);

}
