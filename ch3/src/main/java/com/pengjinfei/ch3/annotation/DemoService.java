package com.pengjinfei.ch3.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Service
public class DemoService {

    public void output() {
        System.out.println("组合注解中的bean");
    }
}
