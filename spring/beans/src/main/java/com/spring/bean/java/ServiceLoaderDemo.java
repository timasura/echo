package com.spring.bean.java;

import com.spring.bean.factory.UserFactory;
import com.spring.bean.factory.impl.UserFactoryImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoaderDemo {

    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/bean-service-loader-context.xml");

        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        ServiceLoader<UserFactory> userFactory = beanFactory.getBean("userFactory", ServiceLoader.class);

        displayServiceLoader(userFactory);

//        demoServiceLoader();


        UserFactoryImpl bean = beanFactory.createBean(UserFactoryImpl.class);

        System.out.println(" bean = " + bean.createUser());


    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {

        Iterator<UserFactory> iterator = serviceLoader.iterator();

        while (iterator.hasNext()) {
            UserFactory next = iterator.next();
            System.out.println(next.createUser());
        }

    }


    // Java 的控制反转
    private static void demoServiceLoader() {

        ServiceLoader<UserFactory> load = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());

        displayServiceLoader(load);

    }





}
