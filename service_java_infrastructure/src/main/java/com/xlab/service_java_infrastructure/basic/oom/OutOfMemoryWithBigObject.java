/*
 * module: fundermental
 * file: OutOfMemoryWithBigObject.java
 * date: 9/6/19 10:56 AM
 * author: VectorJu
 */

/**
 * @create 2019-09-06 10:55
 * @desc test of generate many big object
 **/
package com.xlab.service_java_infrastructure.basic.oom;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryWithBigObject {


    public static void main(String[] args) {
        while (true) {
            World world = new World();
            List<Object> temp = new ArrayList<>(100);
            for (int i=0;i<100;i++) {
                Object object = new Object();
                temp.add(object);
            }
            world.setDiversion("ThisisDiversion");
            world.setObject(new Object());
            world.setContains(temp);
        }
    }
}

