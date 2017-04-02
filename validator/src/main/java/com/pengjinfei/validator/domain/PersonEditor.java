package com.pengjinfei.validator.domain;

import java.beans.PropertyEditorSupport;

/**
 * Created by Pengjinfei on 2017/4/2.
 * Description:
 */
public class PersonEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] split = text.split("_");
        Person person=new Person();
        person.setAge(Integer.parseInt(split[0]));
        person.setName(split[1]);
        setValue(person);
    }

    @Override
    public String getAsText() {
        Person person = (Person) getValue();
        return person.getAge()+"_"+person.getName();
    }
}
