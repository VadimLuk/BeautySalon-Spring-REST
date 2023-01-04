package com.epam.beautysalonspring.converters;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class StringCaseConverter {
    @Named("toEnumCase")
    public String toEnumCase(String enumName) {
        return enumName.toUpperCase();
    }
}
