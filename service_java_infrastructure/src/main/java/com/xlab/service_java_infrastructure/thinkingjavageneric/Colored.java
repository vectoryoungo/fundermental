/*
 * module: fundermental
 * file: Colored.java
 * date: 4/9/19 2:22 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 14:22
 * @desc test of generic color
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class Colored<T extends HasColor> {

    T item;

    Colored(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }
}

