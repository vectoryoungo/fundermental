package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter23;

public class Client {

    public static void main(String[] args) {
        Handler handler = new ConcreteHandler();
        handler.setSuccessor(null);
        handler.handleRequest();
    }
}
