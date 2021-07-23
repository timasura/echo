package com.spring.bean;

import com.spring.bean.factory.UserFactoryBean;
import com.spring.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

//@Import(AnnotationBeanDefinitionDemo.Config.class)
public class BeanCreationDemo {

    public static void main(String[] args) {
        // 创建 Spring 容器
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-creation-context.xml");

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;

            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);

            System.out.println("根据type实时查找集合类型：" + users);

        }

    }


}
