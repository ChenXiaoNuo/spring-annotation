package com.spring.learn.config;

import com.spring.learn.bean.Person;
import com.spring.learn.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 配置类等同于以前的配置文件
 */
@Configuration
//@ComponentScan value:指定需要扫描的包
//excludeFilters = Filter[], 指定扫描的时候按照扫描规则排除哪些组件
//includeFilters = Filter[], 指定扫描的时候只需要包含哪些组件
//useDefaultFilters=false, 取消默认扫描的规则，配合includeFilters使用
//FilterType.ANNOTATION 注解
//FilterType.ASSIGNABLE_TYPE 类型
//FilterType.ASPECTJ 使用ASPECTJ表达式
//FilterType.REGEX 正则表达式
//FilterType.CUSTOM 自定义规则
@ComponentScan(value = "com.spring.learn",
        useDefaultFilters = false,
        includeFilters = {//@Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})}
)
public class AppConfig {

    @Bean
    public Person person(){
        return new Person("lisi", 20);
    }

}
