package com.spring.ioc.container;

import com.spring.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author ：kelvin
 * @date ：2021/7/11
 * @description ：
 */
@ComponentScan
public class ApplicationContextIOCContainerDemo {

    public static void main(String[] args) {

        // 创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationContextIOCContainerDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        lookupCollecationByType(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public User user() {
        User u = new User();
        u.setId(129);
        u.setName(" Lias ");
        return u;
    }


    private static void lookupCollecationByType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;

            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);

            System.out.println("根据type实时查找集合类型：" + users);

        }
    }

}
