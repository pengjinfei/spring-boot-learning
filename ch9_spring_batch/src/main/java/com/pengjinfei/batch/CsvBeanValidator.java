package com.pengjinfei.batch;


import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by Pengjinfei on 16/9/12.
 * Description:
 */
public class CsvBeanValidator<T> implements Validator<T> ,InitializingBean{

    private javax.validation.Validator validator;

    @Override
    public void validate(T t) throws ValidationException {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        if (constraintViolations.size() > 0) {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                message.append(constraintViolation.getMessage()).append(System.getProperty("line.separator", "\n"));
            }
            throw new ValidationException(message.toString());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator=validatorFactory.usingContext().getValidator();
    }
}
