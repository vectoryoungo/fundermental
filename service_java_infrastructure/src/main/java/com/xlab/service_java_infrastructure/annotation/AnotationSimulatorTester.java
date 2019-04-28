/*
 * module: fundermental
 * file: AnotationSimulatorTester.java
 * date: 4/28/19 4:22 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-28 16:22
 * @desc test of annotation
 **/
package com.xlab.service_java_infrastructure.annotation;

import java.lang.reflect.Method;

@Writer(name = "vector",age = 22)
public class AnotationSimulatorTester {

    @Writer(name = "forker",age = 33)
    public void writerInfo() {
        System.out.println(" this is writer ");
    }

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.xlab.service_java_infrastructure.annotation.AnotationSimulatorTester");
            if (clazz.isAnnotationPresent(Writer.class)) {
                Writer writer = (Writer) clazz.getAnnotation(Writer.class);
                System.out.println("writer name is " + writer.name() + " age is " + writer.age());
            }

            Method[] methods = clazz.getMethods();

            for (Method method:methods) {
                if (method.isAnnotationPresent(Writer.class)) {
                    Writer writer = method.getAnnotation(Writer.class);
                    System.out.println(" writer info name is " + writer.name() + " age is " + writer.age());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

