package com.maria.ass1.validators;


import org.springframework.stereotype.Component;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
@Component
public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    private static final String EMAIL_PATTERN = ".+@.+\\.[a-zA-Z]+";
    @Override
    public void initialize(EmailConstraint email) {
    }
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return email != null && pattern.matcher(email).matches();
    }
}
