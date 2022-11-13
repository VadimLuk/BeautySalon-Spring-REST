package com.epam.beautysalonspring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface EnumMapper {
    @Named("toEnumCase")
    default String toEnumCase(String enumName) {
        return enumName.toUpperCase();
    }
}
