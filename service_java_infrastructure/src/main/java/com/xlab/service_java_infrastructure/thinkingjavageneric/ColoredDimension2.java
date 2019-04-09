/*
 * module: fundermental
 * file: ColoredDimension2.java
 * date: 4/9/19 3:17 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 15:17
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T> {

    ColoredDimension2(T item) {
        super(item);
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