package com.pengjinfei.ch2.event;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class EventConfigTest {

    @Test
    public void testEvent() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoEventPublisher publisher = context.getBean(DemoEventPublisher.class);
        publisher.publish("hello application event");
        context.close();
    }
}