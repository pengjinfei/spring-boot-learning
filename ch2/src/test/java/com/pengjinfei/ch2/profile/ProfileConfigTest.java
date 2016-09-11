package com.pengjinfei.ch2.profile;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class ProfileConfigTest {

    @Test
    public void testProfile() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prd");
        context.register(ProfileConfig.class);
        context.refresh();

        DemoBean bean = context.getBean(DemoBean.class);
        System.out.println(bean.getContent());
        context.close();
    }

}