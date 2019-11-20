package com.spring.learn.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

    //返回一个Color对象，这个对象会添加到容器中
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean --> getObject()");
        return new Color();
    }

    //
    public Class<?> getObjectType() {
        return Color.class;
    }

    //是否单例 true是单实例 false多实例
    public boolean isSingleton() {
        return true;
    }
}
