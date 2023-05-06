package com.maria.ass1.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
//A password is considered valid if all the following constraints are satisfied:
//
//        It contains at least 8 characters and at most 20 characters.
//        It contains at least one digit.
//        It contains at least one upper case alphabet.
//        It contains at least one lower case alphabet.
//        It contains at least one special character which includes !@#$%&*()-+=^.
//        It doesn’t contain any white space.
@Component
public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {
    private static final String PASSWORD_PATTERN = ".+[a-zA-Z0-9]{3}";
    @Override
    public void initialize(PasswordConstraint password) {
    }
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        return password!=null && pattern.matcher(password).matches();
    }
}