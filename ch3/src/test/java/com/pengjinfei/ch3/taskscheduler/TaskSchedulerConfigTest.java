package com.pengjinfei.ch3.taskscheduler;

import com.pengjinfei.ch3.conditional.ConditionConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;

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

    @Test
    public void testController() {
        Controller annotation = AnnotationUtils.findAnnotation(ConditionConfig.class, Controller.class);
        System.out.println("abc");
    }

}