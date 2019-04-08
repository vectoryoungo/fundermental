/*
 * module: fundermental
 * file: BasicGenerator.java
 * date: 4/8/19 8:09 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-08 08:08
 * @desc basic generator of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {


        try {
            return type.newInstance();
        }catch (InstantiationException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }
}

