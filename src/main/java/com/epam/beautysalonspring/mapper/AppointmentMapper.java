package com.epam.beautysalonspring.mapper;

import com.epam.beautysalonspring.dto.AppointmentDto;
import com.epam.beautysalonspring.model.Appointment;
import com.epam.beautysalonspring.repository.SalonServiceRepository;
import com.epam.beautysalonspring.repository.UserRepository;
import org.mapstruct.*;
import org.springframework.data.domain.Page;


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


    @Mappings({
            @Mapping(target = "salonServiceName", source = "salonService.name"),
            @Mapping(target = "masterId", source = "master.id"),
            @Mapping(target = "masterName", source = "master.firstName"),
            @Mapping(target = "clientId", source = "client.id"),
            @Mapping(target = "clientFirstName", source = "client.firstName"),
            @Mapping(target = "clientLastName", source = "client.lastName")
    })
    AppointmentDto mapToAppointmentDto(Appointment appointment);

    @Mappings({
            @Mapping(target = "status", source = "status", qualifiedByName = "toEnumCase"),
            @Mapping(target = "master", source = "masterId"),
            @Mapping(target = "salonService", source = "salonServiceId")
    })
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAppointmentFromAppointmentDto(AppointmentDto appointmentDto, @MappingTarget Appointment appointment);

    default Page<AppointmentDto> mapToAppointmentDtoPage(Page<Appointment> appointments) {
        return appointments.map(this::mapToAppointmentDto);
    }
}
