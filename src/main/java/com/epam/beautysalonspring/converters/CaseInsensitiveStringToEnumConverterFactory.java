package com.epam.beautysalonspring.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import java.util.Locale;


// Custom EnumConverterFactory for converting Requested Enums case independently

@SuppressWarnings({"rawtypes", "unchecked"})
@Component
public class CaseInsensitiveStringToEnumConverterFactory implements ConverterFactory<String, Enum> {
    @Override
    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        return new CaseInsensitiveStringToEnum<>(targetType);
    }

    private static class CaseInsensitiveStringToEnum<T extends Enum> implements Converter<String, T> {

        private Class<T> enumType;

        CaseInsensitiveStringToEnum(Class<T> enumType) {
            this.enumType = enumType;
        }

        @Override
        public T convert(String source) {
            return (T) Enum.valueOf(this.enumType, source.toUpperCase(Locale.US));
        }
    }
}
