package com.epam.beautysalonspring.converters;

import com.epam.beautysalonspring.model.enums.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Role role) {
        if (role == null) {
            return null;
        }
        return role.getId();
    }

    @Override
    public Role convertToEntityAttribute(Integer id) {
        return Role.getRole(id);
    }
}
