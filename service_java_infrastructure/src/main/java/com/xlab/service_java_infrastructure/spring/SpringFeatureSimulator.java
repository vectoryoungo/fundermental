/*
 * module: fundermental
 * file: SpringFeatureSimulator.java
 * date: 9/12/19 1:55 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-12 13:54
 * @desc learn spring feature
 **/
package com.xlab.service_java_infrastructure.spring;

import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.BeanMetadataAttribute;
import org.springframework.beans.BeanMetadataAttributeAccessor;
import org.springframework.beans.BeanMetadataElement;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.PlatformTransactionManagerCustomizer;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.AttributeAccessor;
import org.springframework.core.AttributeAccessorSupport;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.web.context.ContextLoaderListener;

import java.lang.reflect.Proxy;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;

@Configuration
public class SpringFeatureSimulator {

    public static void main(String[] args) {
        //Proxy proxy;
        //AopAutoConfiguration.CglibAutoProxyConfiguration cglibAutoProxyConfiguration;
        //AopAutoConfiguration.JdkDynamicAutoProxyConfiguration jdkDynamicAutoProxyConfiguration;
        //AnnotationConfigServletWebServerApplicationContext annotationConfigServletWebServerApplicationContext;
        //AnnotationConfigReactiveWebServerApplicationContext annotationConfigReactiveWebServerApplicationContext;
        AttributeAccessor attributeAccessor;
        AttributeAccessorSupport attributeAccessorSupport;
        BeanDefinition beanDefinition;
        BeanMetadataAttributeAccessor beanMetadataAttributeAccessor;
        BeanMetadataElement beanMetadataElement;
        AbstractBeanDefinition abstractBeanDefinition;
        RootBeanDefinition rootBeanDefinition;
        BeanDefinitionReader beanDefinitionReader;
        XmlBeanDefinitionReader xmlBeanDefinitionReader;
        BeanFactory beanFactory;
        ListableBeanFactory listableBeanFactory;
        HierarchicalBeanFactory hierarchicalBeanFactory;
        AutowireCapableBeanFactory autowireCapableBeanFactory;
        XmlBeanFactory xmlBeanFactory;

        DefaultSingletonBeanRegistry defaultSingletonBeanRegistry;
        ApplicationContext applicationContext;



        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        classPathXmlApplicationContext.refresh();
        Executors executors;
        Executor executor;
        DefaultListableBeanFactory defaultListableBeanFactory;
        RejectedExecutionHandler rejectedExecutionHandler;
        PlatformTransactionManagerCustomizer platformTransactionManagerCustomizer;
        ContextLoaderListener contextLoaderListener;
        ClassPathScanningCandidateComponentProvider classPathScanningCandidateComponentProvider;
        InstantiationAwareBeanPostProcessorAdapter instantiationAwareBeanPostProcessorAdapter;
        PoolProperties poolProperties = new PoolProperties();
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(SpringFeatureSimulator.class);
        annotationConfigApplicationContext.refresh();
        InjectionInnerClass injectionInnerClass = annotationConfigApplicationContext.getBean(InjectionInnerClass.class);
        injectionInnerClass.msgNotification();
        PropertySource propertySource;
        Environment environment;
        AbstractApplicationContext abstractApplicationContext;
        //AbstractXmlApplicationContext abstractXmlApplicationContext;
    }

    @VectorComponent
    public static class InjectionInnerClass {
        public void msgNotification() {
            System.out.println(" InjectionInnerClass msgNotification ");
        }
    }


}

