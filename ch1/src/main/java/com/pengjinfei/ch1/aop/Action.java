package com.pengjinfei.ch1.aop;

import java.lang.annotation.*;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
