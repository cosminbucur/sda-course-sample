package com.sda.spring.core.configs.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMyBeanConfig {

    public static void main(String[] args) {
        // create context
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(BeanConfig.class);

        // get bean
        MyBean myBean = appContext.getBean("myBean", MyBean.class);

        // use bean
        myBean.complexOperation();
    }
}
