package com.pengjinfei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Pengjinfei on 16/9/12.
 * Description:
 */
@SpringBootApplication
@ImportResource(locations ={"classpath:sample-steps.xml"})
public class BatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }
}
