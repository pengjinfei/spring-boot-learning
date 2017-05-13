package com.pengjinfei.validator;

import com.pengjinfei.validator.domain.DepondsOnPerson;
import com.pengjinfei.validator.domain.Person;
import com.pengjinfei.validator.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Pengjinfei on 2017/4/3.
 * Description:
 */
public class ValidatorConfigTest {

    @Test
    public void testSpringValidator() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ValidatorConfig.class);
        PersonService personService = context.getBean(PersonService.class);
        DepondsOnPerson depondsOnPerson = new DepondsOnPerson();
        Person person = new Person();
        person.setAge(5);
        person.setName("hello1");
        depondsOnPerson.setPerson(person);
        boolean validate = personService.validateBySpring(depondsOnPerson);
        System.out.println(validate);
        boolean b = personService.validate(depondsOnPerson);
        System.out.println(b);
    }

    @Test
    public void testHibernate() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
/*        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Person person=new Person();
        person.setName("abcd");
        person.setAge(1);
        Set<ConstraintViolation<Person>> set = validator.validate(person, Default.class);
        for (ConstraintViolation<Person> personConstraintViolation : set) {
            String message = personConstraintViolation.getMessage();
            System.out.println(message);
        }
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(person);
        Map<String, String> describe = BeanUtils.describe(person);
        System.out.println(describe);*/
    }
}