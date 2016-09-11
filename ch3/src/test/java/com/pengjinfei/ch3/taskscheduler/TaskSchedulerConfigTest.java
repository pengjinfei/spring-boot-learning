package com.pengjinfei.ch3.taskscheduler;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class TaskSchedulerConfigTest {

    @Test
    public void testScheduler() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
//        context.close();
        Thread.currentThread().join();
    }

}