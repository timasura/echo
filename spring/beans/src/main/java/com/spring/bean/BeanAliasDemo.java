package com.spring.bean;

import com.spring.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAliasDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-definition-context.xml");

        User user = beanFactory.getBean("user", User.class);
        User userAlias = beanFactory.getBean("user-alias", User.class);

        System.out.println( "userAlias == user : "  + (user == userAlias));

    }
}
