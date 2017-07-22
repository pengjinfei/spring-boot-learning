package com.pengjinfei.redis.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 5/21/17.
 * Description:
 */
@Service
public class HelloServiceImpl2 implements HelloService {
    @Override
    @ServiceActivator(inputChannel = "queueChannel")
    public void sayHello(String name) {
        System.out.println(name + "good");;
    }
}
