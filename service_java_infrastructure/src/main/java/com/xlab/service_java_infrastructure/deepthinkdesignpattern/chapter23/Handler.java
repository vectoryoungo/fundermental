package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter23;


/**
 * 定义职责的接口，通常在这里定义处理请求的方法，可以在这里实现后继链
 */
public abstract class Handler {

    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest();
}
