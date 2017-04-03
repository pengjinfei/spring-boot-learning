package com.pengjinfei.validator.service;

import com.pengjinfei.validator.domain.DepondsOnPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

/**
 * Created by Pengjinfei on 2017/4/3.
 * Description:
 */
@Service
public class PersonService {

    @Autowired
    Validator validator;

    public boolean validate(DepondsOnPerson depondsOnPerson) {
        DataBinder dataBinder = new DataBinder(depondsOnPerson);
        dataBinder.setValidator(validator);
        dataBinder.validate();
        BindingResult bindingResult = dataBinder.getBindingResult();
        return !bindingResult.hasErrors();
    }
}
