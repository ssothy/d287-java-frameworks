package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 *
 *
 *
 *
 */
@Documented
@Constraint(validatedBy = {EnufPartsValidator.class})
@Target({ElementType.TYPE_USE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEnufParts {
    String message() default "There aren't enough parts in inventory or new inventory is less than the current inventory!";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
