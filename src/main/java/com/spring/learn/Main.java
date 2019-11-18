package com.spring.learn;

import com.spring.learn.bean.Person;
import com.spring.learn.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        Person person = ac.getBean(Person.class);
//        System.out.println(person);

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = ac.getBean(Person.class);
        System.out.println(person);

        String[] beanNamesForType = ac.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
}
