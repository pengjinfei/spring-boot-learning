package com.pengjinfei.redis.service;

import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by Pengjinfei on 5/21/17.
 * Description:
 */
@MessagingGateway(name = "entryGateway", defaultRequestChannel = "helloWorldChannel")
public interface GreeterService {
    void greeting(String name);
}
