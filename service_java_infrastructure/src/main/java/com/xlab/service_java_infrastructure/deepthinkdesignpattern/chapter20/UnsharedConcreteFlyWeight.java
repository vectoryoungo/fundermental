package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter20;

/**
 * 非共享的享元对象
 */
public class UnsharedConcreteFlyWeight implements Flyweight {


    private String allState;

    @Override
    public void operation(String extrinsicState) {
        //specific operation
    }
}
