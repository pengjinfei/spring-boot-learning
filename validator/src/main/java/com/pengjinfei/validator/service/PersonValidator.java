package com.pengjinfei.validator.service;

import com.pengjinfei.validator.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Pengjinfei on 2017/4/3.
 * Description:
 */
public class PersonValidator implements ConstraintValidator<PersonConstraint,Person>{

    @Autowired
    SpringService springService;

    @Override
    public void initialize(PersonConstraint constraintAnnotation) {
        System.out.println("initialize.");
    }

    @Override
    public boolean isValid(Person value, ConstraintValidatorContext context) {
        if (springService.validate(value.getName(),value.getAge())) {
            return true;
        }
        return false;
    }
}
