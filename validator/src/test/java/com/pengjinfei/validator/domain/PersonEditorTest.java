package com.pengjinfei.validator.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanWrapperImpl;

/**
 * Created by Pengjinfei on 2017/4/2.
 * Description:
 */
@Slf4j
public class PersonEditorTest {

    @Test
    public void testPersonEditor() {
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl();
        Person person = beanWrapper.convertIfNecessary("1_hello", Person.class);
        log.info(person.toString());
    }

    @Test
    public void testPersonBeanInfo() {
        Person person=new Person();
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(person);
        beanWrapper.setPropertyValue("age","1");
        //beanWrapper.setPropertyValue("name","hello");
        log.info(person.toString());
    }
}