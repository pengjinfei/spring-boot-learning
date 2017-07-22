package com.pengjinfei.redis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.redis.store.RedisChannelMessageStore;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.integration.store.MessageGroupQueue;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created on 7/22/17
 *
 * @author Pengjinfei
 */
@Configuration
public class IntegrationConfiguration {

    @Bean
    public PublishSubscribeChannel helloWorldChannel() {
        return new PublishSubscribeChannel(executor());
    }


    @Bean
    public TaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        return executor;
    }

    @Bean
    public QueueChannel queueChannel(RedisConnectionFactory connectionFactory) {
        RedisChannelMessageStore redisMessageStore = new RedisChannelMessageStore(connectionFactory);
        redisMessageStore.setValueSerializer(new FstSerializer());
        MessageGroupQueue queue = new MessageGroupQueue(redisMessageStore, "queue");
        return new QueueChannel(queue);
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate(30000).get();
    }
}
