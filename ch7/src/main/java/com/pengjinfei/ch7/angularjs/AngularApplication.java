package com.pengjinfei.ch7.angularjs;

import com.pengjinfei.ch7.websocket.WebMvcConfig;
import com.pengjinfei.ch7.websocket.WebSecurityConfig;
import com.pengjinfei.ch7.websocket.WebSocketConfig;
import com.pengjinfei.ch7.websocket.WsApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@SpringBootApplication
@RestController
@ImportAutoConfiguration({WebMvcConfig.class, WebSecurityConfig.class, WebSocketConfig.class, WsApplication.class})
public class AngularApplication {

    @RequestMapping(value = "/search",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName) {
        return new Person(personName, 32, "hefei");
    }

    public static void main(String[] args) {
        SpringApplication.run(AngularApplication.class, args);
    }
}
