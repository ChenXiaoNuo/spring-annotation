package com.spring.learn.condition;

import com.spring.learn.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类，
     *                 把所有需要添加到容器的bean，
     *                 调用 BeanDefinitionRegistry.registerBeanDefinitions收工注册进来
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.spring.learn.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.spring.learn.bean.Blue");
        if (red && blue) {
            registry.registerBeanDefinition("rainBow", new RootBeanDefinition(RainBow.class));
        }
    }
}
