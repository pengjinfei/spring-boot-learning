package com.pengjinfei.ch5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@SpringBootApplication
@RestController
public class WebApplication {

    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;

    @RequestMapping("/")
    String index() {
        return "book name is: "+bookName+", author is: "+bookAuthor;
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);

/*
        new SpringApplicationBuilder(WebApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
*/
    }
}
