/*
 * module: fundermental
 * file: FactoryGeneric.java
 * date: 4/7/19 10:08 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 10:08
 * @desc generic of factory
 **/
package com.xlab.service_java_infrastructure.deepthinkgof.refactor;

public class FactoryGeneric<T> {

   public static <T> T createObject(Class<T> tClass){

        T t = null;
        try {
            t = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return t;
    }
}

