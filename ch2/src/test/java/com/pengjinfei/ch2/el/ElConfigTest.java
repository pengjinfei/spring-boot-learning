package com.pengjinfei.ch2.el;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class ElConfigTest {

    @Test
    public void testEl() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig elConfig = context.getBean(ElConfig.class);
        elConfig.output();
        context.close();
    }

}