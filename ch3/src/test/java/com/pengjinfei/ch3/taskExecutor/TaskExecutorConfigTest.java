package com.pengjinfei.ch3.taskExecutor;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class TaskExecutorConfigTest {

    @Test
    public void testAsync() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService taskService = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            taskService.executeAsyncTask(i);
            taskService.executeAsyncTaskPlus(i);
        }
        Thread.sleep(100000);
//        context.close();
    }

}