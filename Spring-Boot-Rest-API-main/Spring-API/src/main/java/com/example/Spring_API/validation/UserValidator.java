package com.example.Spring_API.validation;

import com.example.Spring_API.api.model.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserValidator implements ConstraintValidator<ValidUser, User> {

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        boolean valid = true;

        // Check age
        if (user.getAge() <= 0 || user.getAge() > 999) {
            context.buildConstraintViolationWithTemplate("Age must be between 1 and 999")
                    .addPropertyNode("age")
                    .addConstraintViolation();
            valid = false;
        }

        // Check phone number length
        if (user.getPhone().length() > 10) {
            context.buildConstraintViolationWithTemplate("Phone number must be at most 10 characters")
                    .addPropertyNode("phone")
                    .addConstraintViolation();
            valid = false;
        }

        return valid;
    }
}
