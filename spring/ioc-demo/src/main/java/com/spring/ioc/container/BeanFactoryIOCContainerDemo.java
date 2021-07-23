package com.spring.ioc.container;

import com.spring.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author ：kelvin
 * @date ：2021/7/11
 * @description ：
 */
public class BeanFactoryIOCContainerDemo {

    public static void main(String[] args) {

        // 创建BeanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 加载配置
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:META-INF/dependency-lookup-context.xml";
        int beanDefinitionsCount = reader.loadBeanDefinitions(location);

        System.out.println( " 加载配置总数: "  + beanDefinitionsCount);


        lookupCollecationByType(beanFactory);
    }


    private static void lookupCollecationByType(BeanFactory beanFactory) {

        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;

            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);

            System.out.println("根据type实时查找集合类型：" + users);

        }
    }

}
