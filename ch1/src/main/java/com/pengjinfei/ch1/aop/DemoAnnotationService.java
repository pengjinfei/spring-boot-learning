package com.pengjinfei.ch1.aop;

import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Service
public class DemoAnnotationService {

    @Action(name = "注解AOP")
    public void add() {

    }
}
