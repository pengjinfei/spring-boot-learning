package com.pengjinfei.ch2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Component
public class DemoEventPublisher {

    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg) {
        applicationContext.publishEvent(new DemoEvent(this,msg));
    }
}
