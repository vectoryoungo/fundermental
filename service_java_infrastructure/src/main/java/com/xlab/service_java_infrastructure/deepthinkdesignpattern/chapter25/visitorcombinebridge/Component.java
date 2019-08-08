/*
 * module: fundermental
 * file: Component.java
 * date: 8/8/19 4:06 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 16:05
 * @desc 抽象的组件对象，相当于访问者模式中的元素对象
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.visitorcombinebridge;

public abstract class Component {

    public abstract void accept(Visitor visitor);

    public void addChild(Component child){
        throw new UnsupportedOperationException("unsupport addChild");
    }

    public void removeChild(Component child){
        throw new UnsupportedOperationException("unsupport removeChild");
    }

    public Component getChild(int index) {
        throw new UnsupportedOperationException("unsupport getchild");
    }
}

