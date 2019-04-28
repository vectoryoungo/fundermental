/*
 * module: fundermental
 * file: Writer.java
 * date: 4/28/19 4:20 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-28 16:20
 * @desc test of annotation
 **/
package com.xlab.service_java_infrastructure.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Writer {
    String name();
    int age();
}

