package com.spring.learn.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    /**
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return 返回值就是导入到容器中的组件全类名
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.spring.learn.bean.Yellow","com.spring.learn.bean.Blue"};
    }
}
