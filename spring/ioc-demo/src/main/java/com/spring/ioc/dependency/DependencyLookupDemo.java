package com.spring.ioc.dependency;

import com.spring.ioc.annotation.Super;
import com.spring.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author ：kelvin
 * @date ：2021/7/6
 * @description ：依赖查找
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-lookup-context.xml");


        // 依赖查找：根据name实时查找
        lookupRealTime(beanFactory);

        // 依赖查找：根据name延迟查找
        lookupLazy(beanFactory);

        // 依赖查找：根据type实时查找
        lookupByType(beanFactory);

        // 依赖查找：根据type实时查找集合类型
        lookupCollecationByType(beanFactory);

        // 依赖查找：根据注解实时查找
        lookupByAnnotation(beanFactory);







    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beans = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("通过 @Super 注解查找：" + beans);

        }
    }

    private static void lookupCollecationByType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;

            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);

            System.out.println("根据type实时查找集合类型：" + users);

        }
    }

    private static void lookupByType(BeanFactory beanFactory) {

        User bean = beanFactory.getBean(User.class);

        System.out.println("根据type实时查找：" + bean);

    }

    private static void lookupLazy(BeanFactory beanFactory) {

        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");

        User user = objectFactory.getObject();

        System.out.println("延迟查找：" + user);

    }

    public static void lookupRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }

}
