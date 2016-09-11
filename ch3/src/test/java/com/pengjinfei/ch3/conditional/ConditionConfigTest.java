package com.pengjinfei.ch3.conditional;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class ConditionConfigTest {

    @Test
    public void testConditional() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println("当前系统的列表命令为: "+listService.showListCmd());
        context.close();
    }

}