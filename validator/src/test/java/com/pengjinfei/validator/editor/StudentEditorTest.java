package com.pengjinfei.validator.editor;

import com.pengjinfei.validator.domain.DepondsOnStudent;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Pengjinfei on 2017/4/2.
 * Description:
 */
public class StudentEditorTest {

    @Test
    public void testCustomEditor() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-editor.xml");
        DepondsOnStudent depondsOnStudent = (DepondsOnStudent) context.getBean("depondsOnStudent");
        System.out.println(depondsOnStudent.getStudent().toString());
    }
}