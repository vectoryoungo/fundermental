/*
 * module: fundermental
 * file: ConcurrentContainer.java
 * date: 12/26/18 6:06 PM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 18:06
 * @desc cotainer
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentContainer {

    volatile List<Object> containers = new ArrayList<>();

    public void add(Object o) {
        containers.add(o);
    }

    public int size() {
        return containers.size();
    }
}

