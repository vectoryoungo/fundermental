/*
 * module: fundermental
 * file: SPIMain.java
 * date: 4/22/20 10:31 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-22 22:31
 * @desc SPIMain test spi
 **/
package com.xlab.service_java_infrastructure.spi;

import java.util.ServiceLoader;

public class SPIMain {

    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
    }
}

