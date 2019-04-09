/*
 * module: fundermental
 * file: ColoredDimension.java
 * date: 4/9/19 2:26 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 14:25
 * @desc test of generic extends
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class ColoredDimension<T extends Dimension & HasColor> {

    T item;

    ColoredDimension(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY(){
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

