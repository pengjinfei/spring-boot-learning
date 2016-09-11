package com.pengjinfei.ch1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Service
public class UseFunctionService {
    @Autowired
    FunctionService functionService;

    public String sayHello(String word) {
        return functionService.sayHello(word);
    }

    public FunctionService getFunctionService() {
        return functionService;
    }

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }
}
