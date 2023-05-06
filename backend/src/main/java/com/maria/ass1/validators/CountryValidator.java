package com.maria.ass1.validators;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CountryValidator implements ConstraintValidator<CountryConnstraint, String> {
    private static final String COUNTRY_PATTERN = "([A-Z][a-z]{2,}[ '-]?([a-z][ -])?)*";

    public void initialize(CountryConnstraint country) {
    }
    @Override
    public boolean isValid(String country, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(COUNTRY_PATTERN);
        return country != null && pattern.matcher(country).matches();
    }
}
