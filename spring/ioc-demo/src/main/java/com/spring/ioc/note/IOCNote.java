package com.spring.ioc.note;

/**
 * @author ：kelvin
 * @date ：2021/7/11
 * @description ：
 *
 * 1. Spring 各个模块都提供什么功能
 *
 * core:
 * beans: 依赖注入、依赖查找(BeanFactory)
 * context: 国际化、应用开发(ApplicationContext)
 *
 * 2. BeanFactory 和 ApplicationContext 的区别
 *
 *
 *
 * 3. IOC容器的启动流程
 *      1. 创建BeanFactory
 *      2. 容器 前置处理
 *      3. Bean 前置处理
 *
 *
 *
 *
 * Bean
 *
 * 1. 什么是BeanDefinition？
 *  BeanDefinition 是 定义Bean的配置元信息的接口 ，包含 Bean的名称、作用域、依赖、生命周期回调、属性配置等
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * Builder模式：构建不可变的对象、简化构造方法 BeanDefinitionBuilder
 *
 *
 * 启动流程
 *  1、定义BeanDefinition
 *    1. XML
 *      XML
 *      @Bean
 *    2. API
 *      BeanDefinitionBuilder.getBeanDefinition();
 *      AbstractBeanDefinition.
 *
 *
 *
 *  2、注册 BeanDefinition 到 Spring 容器
 *    1. 注解
 *      @ComponentScan + @Component
 *      @Import
 *    2. API
 *      命名 Bean 的注册方法：applicationContext. ("user" , beanDefinition);
 *      非命名 Bean 的注册方法：BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition , applicationContext);
 *
 *
 *  3、实例化Bean
 *      1. 构造器、Setter
 *      2. 静态工厂方法
 *      3. FactoryBean
 *      4. ServiceLoaderFactoryBean
 *      5. AutowireCapableBeanFactory.createBean
 *      6. applicationContext.registerBeanDefinition
 *
 *  4、初始化Bean
 *
 *      1. 使用 @PostConstruct 注解
 *      2. 实现 InitializationBean 接口
 *      3. @Bean(initMethod = "init")
 *
 *  5、销毁Bean
 *
 *      1. 使用 @PreDestroy 注解
 *      2. 实现 DisposableBean 接口
 *      3. @Bean(destroyMethod = "destroy")
 *
 *
 *  6、Bean GC
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class IOCNote {
}
