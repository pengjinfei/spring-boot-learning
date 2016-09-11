package com.pengjinfei.ch1.service;

import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Service
public class FunctionService {
    public String sayHello(String word) {
        return "Hello " + word;
    }
}
