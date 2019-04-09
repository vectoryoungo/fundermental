/*
 * module: fundermental
 * file: Bounded.java
 * date: 4/9/19 2:34 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 14:34
 * @desc test of generic extends
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class Bounded extends Dimension implements HasColor,Weight{

    public java.awt.Color getColor() {
        return null;
    }

    public int weight() {
        return 0;
    }
}

