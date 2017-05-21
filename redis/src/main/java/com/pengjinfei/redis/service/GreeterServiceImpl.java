package com.pengjinfei.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 5/21/17.
 * Description:
 */
@Service
public class GreeterServiceImpl implements GreeterService {

    @Autowired
    MessageChannel helloWorldChannel;

    @Override
    public void greeting(String name) {
        long start = System.currentTimeMillis();
        helloWorldChannel.send( MessageBuilder.withPayload( name ).build() );
        System.out.println(System.currentTimeMillis()-start);
    }
}
