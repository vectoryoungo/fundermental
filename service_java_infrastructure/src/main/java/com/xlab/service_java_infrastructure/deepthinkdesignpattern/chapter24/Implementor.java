package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter24;

/**
 * 定义实现部分的接口。这个接口不用和Abstraction中的方法一致，通常是由Implementor接口提供基本的操作。
 * 而Abstraction中定义的是基于这些基本操作的业务方法，也就是说Abstraction定义了基于这些基本操作的比较高
 * 层次的操作。
 */
public interface Implementor {

    public void operationImpl();
}
