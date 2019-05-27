/*
 * module: fundermental
 * file: SingletonTaste.java
 * date: 5/27/19 10:46 AM
 * author: VectorJu
 */

/**
 * @create 2019-05-27 10:45
 * @desc 研磨设计模式更好的单例模式实现方式
 **/
package com.xlab.service_java_infrastructure.basic;

public class SingletonTaste {

    private static class SingletonHolder {
        private static SingletonTaste singletonTaste = new SingletonTaste();
    }

    private SingletonTaste() {}

    public static SingletonTaste getInstance() {
        return SingletonHolder.singletonTaste;
    }
}

