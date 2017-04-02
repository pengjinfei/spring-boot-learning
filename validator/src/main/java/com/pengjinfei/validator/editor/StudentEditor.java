package com.pengjinfei.validator.editor;

import com.pengjinfei.validator.domain.Student;

import java.beans.PropertyEditorSupport;

/**
 * Created by Pengjinfei on 2017/4/2.
 * Description:
 */
public class StudentEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] split = text.split("_");
        Student student=new Student();
        student.setAge(Integer.parseInt(split[0]));
        student.setName(split[1]);
        setValue(student);
    }
}
