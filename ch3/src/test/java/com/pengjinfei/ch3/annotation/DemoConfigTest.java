package com.pengjinfei.ch3.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class DemoConfigTest {

    @Test
    public void testConditional() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService service = context.getBean(DemoService.class);
        service.output();
        context.close();
    }
}