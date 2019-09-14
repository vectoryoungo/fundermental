/*
 * module: fundermental
 * file: VectorComponent.java
 * date: 9/14/19 4:50 PM
 * author: VectorJu
 */

/**
 * @create 2019-09-14 16:50
 * @desc test spring customer annotation use case
 **/
package com.xlab.service_java_infrastructure.spring;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface VectorComponent {
    String value() default "";
}

