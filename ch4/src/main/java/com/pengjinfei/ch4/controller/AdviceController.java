package com.pengjinfei.ch4.controller;

import com.pengjinfei.ch4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj demoObj) {
        throw new IllegalArgumentException("非常抱歉，参数有误/" + "来自@ModelAttribute:" + msg);
    }
}
