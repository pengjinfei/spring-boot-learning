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
        System.out.println(name + "good");;
        System.out.println("good" + name);

        System.out.println("good" + name);
        System.out.println("good" + name);
        System.out.println("i'am good at study");
    }
}
