/*
 * module: fundermental
 * file: Colored2.java
 * date: 4/9/19 3:09 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 15:09
 * @desc test of generic hold
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class Colored2<T extends HasColor> extends HoldItem<T> {

    Colored2(T item) {
        super(item);
    }

    java.awt.Color color() {
        return item.getColor();
    }
}

