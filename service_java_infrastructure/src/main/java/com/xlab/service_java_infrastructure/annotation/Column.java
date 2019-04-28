/*
 * module: fundermental
 * file: Column.java
 * date: 4/28/19 4:35 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-28 16:35
 * @desc Column simulator of mybatis framework
 **/
package com.xlab.service_java_infrastructure.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@Inherited
public @interface Column {
    String value();
}

