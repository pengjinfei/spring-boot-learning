package com.pengjinfei.ch7.thymeleaf;

import com.pengjinfei.ch7.websocket.WebSecurityConfig;
import com.pengjinfei.ch7.websocket.WebSocketConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@SpringBootApplication
@Controller
@ImportAutoConfiguration({WebMvcConfig.class, WebSecurityConfig.class, WebSocketConfig.class})
public class ThymeleafApplication {

    @RequestMapping("/")
    public String index(Model model) {
        Person person1 = new Person("xx",21L);
        Person person2 = new Person("yy",23L);
        Person person3 = new Person("zz",24L);

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        Person single = new Person("aa", 11L);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", persons);
        return "index";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ThymeleafApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}
