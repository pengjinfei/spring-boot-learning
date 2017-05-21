package com.pengjinfei.redis.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Pengjinfei on 5/21/17.
 * Description:
 */
public class HelloServiceImplTest {
    @org.junit.Test
    public void sayHello() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext( "channel.xml" );

        GreeterService greeterService = applicationContext.getBean( "greeterServiceImpl", GreeterService.class );

        greeterService.greeting( "Spring Integration!" );
        Thread.sleep(10000L);
    }

}