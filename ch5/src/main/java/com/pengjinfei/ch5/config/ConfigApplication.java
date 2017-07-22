package com.pengjinfei.ch5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@SpringBootApplication
@RestController
public class ConfigApplication {

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String index() {
        return "author name is: "+authorSettings.getName()+", author age is:"+authorSettings.getAge();
    }

    @GetMapping("/test")
    public String test() throws InterruptedException {
        Thread.sleep(1000*1000);
        return "finally";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
