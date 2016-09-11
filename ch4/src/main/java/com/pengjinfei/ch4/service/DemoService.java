package com.pengjinfei.ch4.service;

import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
@Service
public class DemoService {

    public String saySomething() {
        return "非常抱歉，参数有误/来自@ModelAttribute:额外信息";
    }
}
