package com.sda.spring.core.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoAutowired {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AutowiredConfig.class);

        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.spellCheck();
        textEditor.format();
        textEditor.convertImage();
    }
}
