package com.pengjinfei.ch3.taskExecutor;

import org.slf4j.MDC;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.UUID;
import java.util.concurrent.Executor;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Configuration
@ComponentScan
@EnableAsync
public class TaskExecutorConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.setTaskDecorator(new TaskDecorator() {
            @Override
            public Runnable decorate(Runnable runnable) {
                return new Runnable() {
                    @Override
                    public void run() {
                        MDC.put("mdc", UUID.randomUUID().toString());
                        runnable.run();
                    }
                };
            }
        });
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
