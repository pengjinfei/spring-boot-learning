package com.pengjinfei.redis;

import com.pengjinfei.redis.service.GreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pengjinfei on 5/21/17.
 * Description:
 */
@SpringBootApplication
@EnableIntegration
@RestController
@IntegrationComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private GreeterService greeterService;

    @GetMapping
    public String hello() {
        greeterService.greeting("pengjinfei");
        return "hello";
    }

}
