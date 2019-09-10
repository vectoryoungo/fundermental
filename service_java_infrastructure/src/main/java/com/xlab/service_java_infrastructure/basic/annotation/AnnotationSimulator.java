/*
 * module: fundermental
 * file: AnnotationSimulator.java
 * date: 9/10/19 10:15 AM
 * author: VectorJu
 */

/**
 * @create 2019-09-10 10:14
 * @desc simulate of annotation example
 **/
package com.xlab.service_java_infrastructure.basic.annotation;

import java.lang.annotation.Annotation;

public class AnnotationSimulator {

    public static void main(String[] args) {
        Annotation annotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }
        };
    }
}

