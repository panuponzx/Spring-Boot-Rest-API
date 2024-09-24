package com.example.Spring_API.validation;

import com.example.Spring_API.validation.UserValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UserValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUser {
    String message() default "Invalid user data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
