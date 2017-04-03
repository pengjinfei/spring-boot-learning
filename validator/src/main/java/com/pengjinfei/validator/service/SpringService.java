package com.pengjinfei.validator.service;

import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 2017/4/3.
 * Description:
 */
@Service
public class SpringService {

    public boolean validate(String name, int age) {
        return name.length()==age;
    }
}
