package com.pengjinfei.ch4.controller;

import org.springframework.stereotype.Controller;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Controller
public class HellController {

//    @RequestMapping("/index")
    public String hello() {
        return "index";
    }
}
