/*
 * module: fundermental
 * file: Widget.java
 * date: 4/9/19 8:47 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-09 08:47
 * @desc widget test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric.betterfactory;

public class Widget {

    public static class Factory implements com.xlab.service_java_infrastructure.thinkingjavageneric.betterfactory.Factory<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }

    @Override
    public String toString() {
        return "widget has been created ";
    }
}

