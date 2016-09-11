package com.pengjinfei.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.pengjinfei.ch1.aop.Action)")
    public void annotationPointcut() {

    }

    @After("annotationPointcut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action annotation = method.getAnnotation(Action.class);
        System.out.println("注解拦截-->"+annotation.name());
    }

    @Before("execution(* com.pengjinfei.ch1.aop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则拦截-->"+method.getName());
    }
}
