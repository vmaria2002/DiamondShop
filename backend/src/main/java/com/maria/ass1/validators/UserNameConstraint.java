package com.maria.ass1.validators;

import jdk.jfr.Relational;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;


@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserNameValidator.class)
public @interface UserNameConstraint {
    String message() default "Invalid username. Username trebuie sa contina litere, cifre, minim 3 caractere. Incepe cu majuscula";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
