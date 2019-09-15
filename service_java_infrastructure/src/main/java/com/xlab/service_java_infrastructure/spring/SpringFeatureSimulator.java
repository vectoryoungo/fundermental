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

import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractXmlApplicationContext;

import java.lang.reflect.Proxy;

@Configuration
public class SpringFeatureSimulator {

    public static void main(String[] args) {
        //Proxy proxy;
        //AopAutoConfiguration.CglibAutoProxyConfiguration cglibAutoProxyConfiguration;
        //AopAutoConfiguration.JdkDynamicAutoProxyConfiguration jdkDynamicAutoProxyConfiguration;
        //AnnotationConfigServletWebServerApplicationContext annotationConfigServletWebServerApplicationContext;
        //AnnotationConfigReactiveWebServerApplicationContext annotationConfigReactiveWebServerApplicationContext;
        ClassPathScanningCandidateComponentProvider classPathScanningCandidateComponentProvider;
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(SpringFeatureSimulator.class);
        annotationConfigApplicationContext.refresh();
        InjectionInnerClass injectionInnerClass = annotationConfigApplicationContext.getBean(InjectionInnerClass.class);
        injectionInnerClass.msgNotification();
        //AbstractXmlApplicationContext abstractXmlApplicationContext;
    }

    @VectorComponent
    public static class InjectionInnerClass {
        public void msgNotification() {
            System.out.println(" InjectionInnerClass msgNotification ");
        }
    }


}

