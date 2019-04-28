/*
 * module: fundermental
 * file: Table.java
 * date: 4/28/19 4:33 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-28 16:33
 * @desc table simulator of mybatis framework
 **/
package com.xlab.service_java_infrastructure.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface Table {
    String value() default " ";
}

