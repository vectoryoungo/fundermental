package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter17;

/**
 * 上下文对象，通常会持有一个具体的策略对象。
 * 负责和具体的策略类交互。
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 为上下文对客户端提供的操作接口，可以有参数和返回值。
     */
    public void contextInterface() {
        //通常会转调具体的策略对象进行算法运算
        strategy.algorithmInterface();
    }
}
