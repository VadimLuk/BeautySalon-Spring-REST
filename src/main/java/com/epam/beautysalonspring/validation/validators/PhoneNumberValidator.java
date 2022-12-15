package com.epam.beautysalonspring.validation.validators;

import com.epam.beautysalonspring.validation.annotations.PhoneNumber;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    private String message;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(message);
        if (value == null) return true;
        return value.matches("\\d{12}");
    }
}
