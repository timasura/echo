package com.spring.bean;

import com.spring.bean.factory.UserFactory;
import com.spring.bean.factory.impl.DefaultUserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class BeanInitializationDemo {

    public static void main(String[] args) {

        // 创建 Spring 应用上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        DefaultUserFactory bean = applicationContext.getBean(DefaultUserFactory.class);


        // 关闭 Spring 应用上下文
        System.out.println(" ----- Spring 应用上下文 准备关闭... ");
        applicationContext.close();
        System.out.println(" ----- Spring 应用上下文 已关闭... ");

    }

    @Bean(initMethod = "initUserFactory" , destroyMethod = "doDestroy")
    public DefaultUserFactory defaultUserFactory() {
        return new DefaultUserFactory();
    }
}
