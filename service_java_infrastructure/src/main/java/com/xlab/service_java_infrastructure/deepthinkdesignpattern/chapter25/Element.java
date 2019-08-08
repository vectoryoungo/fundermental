/*
 * module: fundermental
 * file: Element.java
 * date: 8/8/19 11:34 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 11:34
 * @desc 抽象的元素对象，对象结构的顶层接口，定义接受访问的操作。
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25;

public abstract class Element {

    public abstract void accept(Visitor visitor);
}

