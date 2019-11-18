package com.spring.learn.config;

import com.spring.learn.bean.Person;
import com.spring.learn.condition.LinusCondition;
import com.spring.learn.condition.WindowsCondition;
import org.springframework.context.annotation.*;

//满足当前条件，这个类中配置的所有bean注册才能生效
@Conditional({WindowsCondition.class})
@Configuration
public class AppConfig2 {
    /**
     * 默认单实例的
     * prototype:多实例的:ioc容器启动并不会调用方法去创建对象，而是每次调用时创建
     * singleton:单实例的(默认值):ioc容器启动后会调用方法创建对象放到ioc容器中
     *            以后每次获取就是直接从容器(map.get())中拿
     * 懒加载：@Lazy
     *      单实例bean：默认在容器启动的时候创建对象
     *      懒加载：容器启动不创建对象，第一次使用(获取)Bean创建对象，并初始化
     * @return
     */
    //@Scope("prototype")
    //@Lazy
    @Bean("person")
    public Person person(){
        //System.out.println("给容器中添加person");
        return new Person("张三",18);
    }

    /**
     * @Conditional：按照一定的条件进行判断，满足条件给容器中注册bean
     * 如果系统时windows，给容器中注册bill
     * 如果时linux系统，给容器中注册linus
     */
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates", 62);
    }

    @Conditional(LinusCondition.class)
    @Bean("linus")
    public Person person02(){
        return new Person("linus", 48);
    }



}
