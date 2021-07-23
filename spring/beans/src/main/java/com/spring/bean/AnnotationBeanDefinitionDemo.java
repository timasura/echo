package com.spring.bean;

import com.spring.bean.factory.UserFactoryBean;
import com.spring.ioc.domain.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

//@Import(AnnotationBeanDefinitionDemo.Config.class)
@ComponentScan
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 创建 Spring 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationBeanDefinitionDemo.class);


        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(User.class).addPropertyValue("id", 2L).addPropertyValue("name", "us").getBeanDefinition();
        applicationContext.registerBeanDefinition("sas" , beanDefinition);

        BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition , applicationContext);


        System.out.println("启动容器前 ");
        // 启动容器
        applicationContext.refresh();


        System.out.println("启动容器了 ， User = " + applicationContext.getBeansOfType(User.class));
        System.out.println("启动容器了 ， Atest = " + applicationContext.getBeansOfType(UserFactoryBean.class));


        // 关闭容器
        applicationContext.close();

    }

    @Component
    public static class Config{

        @Bean(name = { "newUser" , "userAli"})
        public User user() {
            User u = new User();
            u.setId(79);
            u.setName(" sala ");
            System.out.println(" sala 创建中");
            return u;
        }

    }



}
