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

import java.lang.reflect.Proxy;

public class SpringFeatureSimulator {

    public static void main(String[] args) {
        Proxy proxy;
        AopAutoConfiguration.CglibAutoProxyConfiguration cglibAutoProxyConfiguration;
        AopAutoConfiguration.JdkDynamicAutoProxyConfiguration jdkDynamicAutoProxyConfiguration;
    }
}

