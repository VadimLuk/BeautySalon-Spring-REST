package com.epam.beautysalonspring.converters;

import com.epam.beautysalonspring.model.enums.AppointmentStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AppointmentStatusConverter implements AttributeConverter<AppointmentStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(AppointmentStatus status) {
        if (status == null) {
            return null;
        }
        return status.getId();
    }

    @Override
    public AppointmentStatus convertToEntityAttribute(Integer id) {
        return AppointmentStatus.getAppointmentStatus(id);
    }
}
