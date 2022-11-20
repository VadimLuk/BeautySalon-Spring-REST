package com.epam.beautysalonspring.converters;

import com.epam.beautysalonspring.model.enums.UserStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserStatusConverter implements AttributeConverter<UserStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserStatus status) {
        if (status == null) {
            return null;
        }
        return status.getId();
    }

    @Override
    public UserStatus convertToEntityAttribute(Integer id) {
        return UserStatus.getUserStatus(id);
    }
}
