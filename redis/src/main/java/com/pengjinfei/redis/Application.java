package com.pengjinfei.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pengjinfei on 5/21/17.
 * Description:
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping
    public String hello() {
        return "hello";
    }

}
