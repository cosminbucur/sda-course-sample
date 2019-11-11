package com.sda.spring.mvc.hibernate;

import com.sda.spring.mvc.hibernate.config.PersistenceJpaConfig;
import com.sda.spring.mvc.hibernate.model.User;
import com.sda.spring.mvc.hibernate.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMvcHibernateApplication {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(PersistenceJpaConfig.class);

        UserService userService = context.getBean("userService", UserService.class);

        User user = new User();
        user.setName("jon snow");
        user.setEmail("jonsnow@gmail.com");

        userService.create(user);
    }
}
