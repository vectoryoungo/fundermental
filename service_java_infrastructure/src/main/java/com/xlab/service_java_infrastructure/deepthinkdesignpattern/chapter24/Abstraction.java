package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter24;


/**
 * 抽象部分接口。通常在这个对象中，要维护一个实现部分的对象引用，抽象对象里面的方法，需要调用实现部分的对象来完成。
 * 这个对象中的方法，通常都是和具体的业务相关的方法。
 */
public abstract class Abstraction {

    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation() {
        implementor.operationImpl();
    }
}
