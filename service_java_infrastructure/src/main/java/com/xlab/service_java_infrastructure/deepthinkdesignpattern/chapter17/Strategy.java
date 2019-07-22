package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter17;

/**
 * 策略接口，用来约束一系列具体的策略算法。Context使用这个接口来调用具体的策略实现定义的算法。
 */
public interface Strategy {

    //某个算法的接口，可以有传入参数，也可以有返回值
    public void algorithmInterface();
}
