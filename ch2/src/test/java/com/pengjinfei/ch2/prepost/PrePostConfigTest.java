package com.pengjinfei.ch2.prepost;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class PrePostConfigTest {

    @Test
    public void testPrePost() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);
        context.getBean(BeanWayService.class);
        context.getBean(JSR250WayService.class);
        context.close();
    }

}