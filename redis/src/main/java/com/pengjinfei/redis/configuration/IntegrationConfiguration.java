package com.pengjinfei.redis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created on 7/22/17
 *
 * @author Pengjinfei
 */
@Configuration
public class IntegrationConfiguration {

    @Bean
    public DirectChannel helloWorldChannel() {
        return new DirectChannel();
    }


    @Bean
    public TaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        return executor;
    }
}
