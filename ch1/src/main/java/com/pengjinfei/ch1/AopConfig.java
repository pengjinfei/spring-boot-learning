package com.pengjinfei.ch1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Configuration
@ComponentScan("com.pengjinfei.ch1.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
