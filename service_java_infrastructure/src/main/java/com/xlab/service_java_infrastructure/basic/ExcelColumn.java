/*
 * module: fundermental
 * file: ExcelColumn.java
 * date: 5/15/19 3:25 PM
 * author: VectorJu
 */

package com.xlab.service_java_infrastructure.basic;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {

    String value() default "";

    int col() default 0;
}
