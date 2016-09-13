package com.pengjinfei;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Pengjinfei on 16/9/13.
 * Description:
 */
@SpringBootApplication
public class RabbitMQApplication implements CommandLineRunner {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Override
    public void run(String... args) throws Exception {
        rabbitTemplate.convertAndSend("my-queue","come from rabbitmq!");
    }

    @Bean
    public Queue demoQueue() {
        return new Queue("my-queue");
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);
    }
}
