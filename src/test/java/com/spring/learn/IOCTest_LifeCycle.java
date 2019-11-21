package com.spring.learn;

import com.spring.learn.config.AppConfig2;
import com.spring.learn.config.AppConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigOfLifeCycle.class);

    @Test
    public void test01(){
        System.out.println("容器创建完成");

        //context.getBean("car");
        //关闭容器
        context.close();
    }
}
