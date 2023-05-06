package com.maria.ass1.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Component
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {
    private static final String PHONE_PATTERN = "^(\\+4|)?(07[0-8]{1}[0-9]{1}|02[0-9]{2}|03[0-9]{2}){1}?(\s|\\.|-)?([0-9]{3}(\s|\\.|-|)){2}$";
    @Override
    public void initialize(PhoneNumberConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        return phone != null && pattern.matcher(phone).matches() && (phone.length()==10 || phone.length()==12);
    }
}
