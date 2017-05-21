package com.pengjinfei.redis.service;

import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 5/21/17.
 * Description:
 */
@Service
public class HelloServiceImpl2 implements HelloService {
    @Override
    public void sayHello(String name) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + ",hello!");
    }
}
