package com.pengjinfei.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Component
public class DemoEventListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("I got Message :"+msg);
    }
}
