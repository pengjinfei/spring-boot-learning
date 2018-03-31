package com.pengjinfei.ch1;

import com.pengjinfei.ch1.aop.DemoAnnotationService;
import com.pengjinfei.ch1.aop.DemoMethodService;
import com.pengjinfei.ch1.service.UseFunctionService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class MainTest {

    @Test
    public void testConfigScan() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FunctionServiceConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("spring"));
        Assert.assertEquals(useFunctionService.sayHello("spring"),"Hello spring");
        context.close();
    }

    @Test
    public void testConfiguration() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        Assert.assertEquals(useFunctionService.sayHello("spring"),"Hello spring");
        context.close();
    }

    @Test
    public void testAopConfiguration() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService annotationService = context.getBean(DemoAnnotationService.class);
        annotationService.add();
        DemoMethodService methodService = context.getBean(DemoMethodService.class);
        methodService.add();
        context.close();
    }

    @Test
    public void testLahua() throws Exception{
        String cin = "123";
        switch(cin){
            case "123":
                System.out.println("123");
                break;
            default:
                System.out.println("abd");
                break;
        }
    }

}