package com.spring.learn;

import com.spring.learn.bean.Blue;
import com.spring.learn.bean.Person;
import com.spring.learn.config.AppConfig;
import com.spring.learn.config.AppConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);


    @Test
    public void testImport() {
        printBeans(context);

        //工厂Bean获取的是调用getObject()创建的对象
        Object colorFactoryBean1 = context.getBean("colorFactoryBean");
        System.out.println("colorFactoryBean的类型是：" + colorFactoryBean1.getClass());
        Object colorFactoryBean2 = context.getBean("colorFactoryBean");
        System.out.println(colorFactoryBean1 == colorFactoryBean2);

        Object colorFactoryBean3 = context.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean3);

    }

    private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void test03() {
        String[] names = context.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : names) {
            System.out.println(name);
        }

        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }


    @Test
    public void test02(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
//        Object p1 = context.getBean("person");
//        Object p2 = context.getBean("person");
//        System.out.println(p1 == p2);
    }

    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
