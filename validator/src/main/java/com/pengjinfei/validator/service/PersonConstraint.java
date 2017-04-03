package com.pengjinfei.validator.service;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Pengjinfei on 2017/4/3.
 * Description:
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PersonValidator.class)
public @interface PersonConstraint {
    String message() default "not valid person.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


    @Target({ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        PersonConstraint[] value();
    }
}
