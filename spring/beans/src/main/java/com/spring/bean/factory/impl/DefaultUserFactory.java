package com.spring.bean.factory.impl;

import com.spring.bean.factory.UserFactory;
import com.spring.ioc.domain.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DefaultUserFactory implements UserFactory , InitializingBean , DisposableBean {

    // 通过 @PostConstruct 初始化 Bean
    @PostConstruct
    public void init() {
        System.out.println(" @PostConstruct DefaultUserFactory.init 初始化中... ");
    }

    public void initUserFactory() {
        System.out.println(" 自定义 DefaultUserFactory.initUserFactory 初始化中... ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" InitializingBean DefaultUserFactory.afterPropertiesSet 初始化中... ");
    }


    @PreDestroy
    public void preDestroy() {
        System.out.println(" @PreDestroy DefaultUserFactory.preDestroy 销毁中... ");
    }


    @Override
    public void destroy() {
        System.out.println(" DisposableBean DefaultUserFactory.destroy 销毁中... ");
    }

    public void doDestroy() {
        System.out.println(" 自定义 DefaultUserFactory.doDestroy 销毁中... ");
    }



}
