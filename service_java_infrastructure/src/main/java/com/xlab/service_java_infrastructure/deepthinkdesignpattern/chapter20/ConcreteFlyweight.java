package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter20;

/**
 * 具体的享元对象，必须是可共享的，需要封装Flyweight的内部状态
 */
public class ConcreteFlyweight implements Flyweight {

    private String intrinsicState;

    public ConcreteFlyweight(String state) {
        intrinsicState = state;
    }

    @Override
    public void operation(String extrinsicState) {
        //specific operation
    }
}
