package com.spring.bean;

import com.spring.bean.factory.impl.DefaultUserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {

        // 创建 Spring 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();

        // 创建 外部对象
        DefaultUserFactory userFactory = new DefaultUserFactory();

        // 注册外部对象
        beanFactory.registerSingleton("userFactory" , userFactory);

        // 启动 Spring 容器
        applicationContext.refresh();


        DefaultUserFactory userFactoryByName = applicationContext.getBean("userFactory", DefaultUserFactory.class);
        System.out.println(userFactoryByName == userFactory);

        // 关闭 Spring 容器
        applicationContext.close();








    }
}
