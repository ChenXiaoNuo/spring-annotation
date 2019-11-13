package com.spring.learn;

import com.spring.learn.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        Person person = ac.getBean(Person.class);

        System.out.println(person);
    }
}
