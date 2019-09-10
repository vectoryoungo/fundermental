/*
 * module: fundermental
 * file: Person.java
 * date: 9/10/19 4:24 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-10 16:24
 * @desc test spring lifecycle
 **/
package com.xlab.service_java_infrastructure.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Person implements DisposableBean,InitializingBean{

    private String name;

    Person() {
        System.out.println("Constructor of person bean is invoked!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Bean initialization code
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing method of person bean is invoked!");
    }

    //Bean destruction code
    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy method of person bean is invoked!");
    }
}

