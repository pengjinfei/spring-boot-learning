package com.pengjinfei.validator;

import com.pengjinfei.validator.domain.DepondsOnPerson;
import com.pengjinfei.validator.domain.Person;
import com.pengjinfei.validator.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pengjinfei on 2017/4/3.
 * Description:
 */
public class ValidatorConfigTest {

    @Test
    public void testSpringValidator() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        PersonService bean = context.getBean(PersonService.class);
        DepondsOnPerson depondsOnPerson = new DepondsOnPerson();
        Person person = new Person();
        person.setAge(6);
        person.setName("hello1");
        depondsOnPerson.setPerson(person);
        boolean validate = bean.validate(depondsOnPerson);
        System.out.println(validate);
    }
}