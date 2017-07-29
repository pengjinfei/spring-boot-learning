package com.pengjinfei.redis.service;

import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 5/21/17.
 * Description:
 */
@Service
public class HelloServiceImpl2 implements HelloService {
    @Override
    @ServiceActivator(inputChannel = "queueChannel",poller = {
            @Poller(fixedRate = "30000",maxMessagesPerPoll = "10")
    })
    public void sayHello(String name) {
        System.out.println("begin");;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "good");;
    }
}
