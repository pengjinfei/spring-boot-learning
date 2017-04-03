package com.pengjinfei.validator.service;

import com.pengjinfei.validator.domain.DepondsOnPerson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * Created by Pengjinfei on 2017/4/3.
 * Description:
 */
@Service
@Slf4j
public class PersonService {

    @Autowired
    Validator springValidator;

    @Autowired
    javax.validation.Validator javaValidator;

    public boolean validateBySpring(DepondsOnPerson depondsOnPerson) {
        DataBinder dataBinder = new DataBinder(depondsOnPerson);
        dataBinder.setValidator(springValidator);
        dataBinder.validate();
        BindingResult bindingResult = dataBinder.getBindingResult();
        return !bindingResult.hasErrors();
    }

    public boolean validate(DepondsOnPerson depondsOnPerson) {
        Set<ConstraintViolation<DepondsOnPerson>> validate = javaValidator.validate(depondsOnPerson);
        if (validate.size() > 0) {
            ConstraintViolation<DepondsOnPerson> next = validate.iterator().next();
            log.warn(next.getMessage());
            return false;
        }
        return true;
    }
}
