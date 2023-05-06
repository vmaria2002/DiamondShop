package com.maria.ass1.validators;

import org.springframework.stereotype.Component;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
@Component
public class NameValidator implements ConstraintValidator<NameConstraint, String> {

    private static final String NAME_PATTERN = "([A-Z][a-z]{2,})*";

    @Override
    public void initialize(NameConstraint name) {
    }
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(NAME_PATTERN );
        return name!=null && pattern.matcher(name).matches();
    }
}
