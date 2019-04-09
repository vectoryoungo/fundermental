/*
 * module: fundermental
 * file: ClassAsFactory.java
 * date: 4/9/19 8:28 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 08:28
 * @desc test of generic factory
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class ClassAsFactory<T> {

    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            kind.newInstance();
        }catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException("初始化失败");
        }catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("非法访问");
        }
    }
}

