package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter24;

/**
 * 扩展抽象部分的接口。通常在这些对象中，定义跟实际业务相关的方法，这些方法的实现通常会使用Abstraction中定义的方法，也可能需要调用实现
 * 部分的对象来完成。
 */
public class RefinedAbstraction extends Abstraction {


    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    public void otherOperation() {
        //implement specific logic
    }
}
