package com.spring.bean;

import com.spring.ioc.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {

        // 1. 通过 BeanDefinitionBuilder 构建 BeanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 设置属性
        beanDefinitionBuilder.addPropertyValue("id" , 2 ).addPropertyValue("name" ,"小逖");
        // 获取 BeanDefinition 实例 ，BeanDefinition 并非 Bean 的终态 ，可自定义修改
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        System.out.println(" 通过 BeanDefinitionBuilder 构建 beanDefinition  = " + beanDefinition);


        // 2. 通过 AbstractBeanDefinition 的派生类 构建 BeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        // 设置属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id" , 3 ).add("name" ,"小飒");
        genericBeanDefinition.setPropertyValues(propertyValues);

        System.out.println("通过 AbstractBeanDefinition 的派生类 构建 genericBeanDefinition = " + genericBeanDefinition);


    }
}
