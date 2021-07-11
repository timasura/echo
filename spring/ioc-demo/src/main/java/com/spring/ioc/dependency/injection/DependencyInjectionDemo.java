package com.spring.ioc.dependency.injection;

import com.spring.ioc.annotation.Super;
import com.spring.ioc.domain.User;
import com.spring.ioc.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author ：kelvin
 * @date ：2021/7/6
 * @description ：依赖注入
 *
 * 依赖来源：自定义的Bean、内建的Bean、内建的非Bean
 * 依赖注入 和 依赖查找 的来源不同
 * 自动注入的
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INFO/dependency-injection-context.xml");


        autoInjection(beanFactory);



    }

    private static void autoInjection(BeanFactory beanFactory) {

        UserRepository userRepository = beanFactory.getBean(UserRepository.class);

        // 自动注入 : 来自 自定义的Bean
        System.out.println(userRepository.getUsers());

        // 依赖注入 : 来自 内建的非Bean
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        // 依赖查找（错误）
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        // 依赖注入 : 依赖注入 和 依赖查找 的来源不同
        System.out.println("依赖注入 和 依赖查找 的来源 : " + (userRepository.getObjectFactory() == beanFactory.getBean(ObjectFactory.class)));


        // 依赖注入 Bean
        System.out.println(userRepository.getApplicationContextObjectFactory().getObject());
        System.out.println(userRepository.getApplicationContextObjectFactory().getObject() == beanFactory);

        // 依赖注入 : 来自 内建的Bean
        Environment env = beanFactory.getBean(Environment.class);
        System.out.println( "内建的Bean Environment : " + env);



    }


}
