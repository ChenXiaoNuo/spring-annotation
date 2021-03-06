package com.spring.learn.config;

import com.spring.learn.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean的生命周期：
 *      bean创建---初始化---销毁的过程
 * 容器管理bean的生命周期
 * 可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候会调用我们自定义的初始化和销毁方法
 * 构造(对象创建)
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 * 销毁：
 *      单实例：容器关闭的时候
 *      多实例：容器不会管理这个bean，容器不会调用销毁
 * 1.指定初始化和销毁方法
 *    init-method和destory-method
 * 2.通过让Bean实现InitializingBean(定义初始化逻辑)
 *            实现DisposableBean(定义销毁逻辑)
 * 3.可以使用JSR250规范中的注解：
 *      @PostConstruct : 在bean创建完成并且属性赋值完成，来执行初始化
 *      @PreDestory : 在容器销毁bean之前，通知我们进行清理工作
 *
 *
 */
@Configuration
@ComponentScan("com.spring.learn.bean")
public class AppConfigOfLifeCycle {

    //@Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }
}
