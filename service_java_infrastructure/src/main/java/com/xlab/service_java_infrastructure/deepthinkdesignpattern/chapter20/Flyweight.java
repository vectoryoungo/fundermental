package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter20;

/**
 * 享元接口，通过这个接口Flyweight可以接受并作用于外部状态。
 * 通过这个接口传入外部的状态，在享元对象的方法处理中可能会使用这些外部的
 * 数据
 */
public interface Flyweight {

    public void operation(String extrinsicState);
}

