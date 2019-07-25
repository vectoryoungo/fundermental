package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter18;

public class ConcreteStateOne implements State {
    @Override
    public void handle(String parameter) {
        System.out.println("concrete state one ");
    }
}
