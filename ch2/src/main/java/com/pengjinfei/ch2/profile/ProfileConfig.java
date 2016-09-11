package com.pengjinfei.ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DemoBean devDemoBean() {
        return new DemoBean("from dev");
    }

    @Bean
    @Profile("prd")
    public DemoBean prdDemoBean() {
        return new DemoBean("from prd");
    }
}
