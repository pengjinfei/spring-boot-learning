package com.pengjinfei.ch1;

import com.pengjinfei.ch1.service.FunctionService;
import com.pengjinfei.ch1.service.UseFunctionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Configuration
public class JavaConfig {

    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    /*@Bean
    public UseFunctionService useFunctionService() {
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService());
        return  useFunctionService;
    }*/

    @Bean
    public UseFunctionService useFunctionService(FunctionService functionService) {
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService);
        return  useFunctionService;
    }
}
