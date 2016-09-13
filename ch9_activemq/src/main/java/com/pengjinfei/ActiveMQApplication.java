package com.pengjinfei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

/**
 * Created by Pengjinfei on 16/9/13.
 * Description:
 */
@SpringBootApplication
public class ActiveMQApplication implements CommandLineRunner{
    @Autowired
    JmsTemplate jmsTemplate;
    @Override
    public void run(String... args) throws Exception {
        jmsTemplate.send("my-destination",new Msg());
    }

    public static void main(String[] args) {
        SpringApplication.run(ActiveMQApplication.class, args);
    }
}
