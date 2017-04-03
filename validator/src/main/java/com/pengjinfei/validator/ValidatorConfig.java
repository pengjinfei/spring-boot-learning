package com.pengjinfei.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Created by Pengjinfei on 2017/4/3.
 * Description:
 */
@Configuration
@ComponentScan("com.pengjinfei.validator.service")
public class ValidatorConfig {

    @Bean
    public LocalValidatorFactoryBean validator() throws Exception{
        LocalValidatorFactoryBean factoryBean=new LocalValidatorFactoryBean();
        factoryBean.afterPropertiesSet();
        return factoryBean;
    }
}
