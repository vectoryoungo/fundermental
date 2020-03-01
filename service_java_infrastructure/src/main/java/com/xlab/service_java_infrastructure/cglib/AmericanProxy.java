/*
 * module: fundermental
 * file: AmericanProxy.java
 * date: 2/28/20 2:33 PM
 * author: VectorJu
 */

/**
 * @create 2020-02-28 14:33
 * @desc proxy of American
 **/
package com.xlab.service_java_infrastructure.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AmericanProxy implements MethodInterceptor{
    //proxy method
    public Object createProxy(Object target){
        //create a dynamic object
        Enhancer enhancer=new Enhancer();
        //determine class need to be enhanced ，set super class
        enhancer.setSuperclass(target.getClass());
        //set callback
        enhancer.setCallback(this);
        return enhancer.create();
    }
    /**
     * proxy CGlib根据父类生成的代理对象
     * method 拦截的方法
     * args 拦截方法的参数数组
     * methodProxy 方法的代理对象，用于执行父类的方法
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        AmericanAspect heathAspect=new AmericanAspect();
        heathAspect.checkHealth();
        //execute object method
        Object obj=methodProxy.invokeSuper(proxy,args);
        return obj;
    }
}

