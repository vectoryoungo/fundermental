/*
 * module: fundermental
 * file: HoldItem.java
 * date: 4/9/19 3:07 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 15:07
 * @desc test of generic holditem
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class HoldItem<T> {

    T item;

    HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}

