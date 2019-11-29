/*
 * module: fundermental
 * file: ConcurrentContainerOrigin.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: ConcurrentContainerOrigin.java
 * date: 12/26/18 6:33 PM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 18:32
 * @desc origin
 **/
package com.xlab.service_java_infrastructure.concurrent;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentContainerOrigin {

    List<Object> containers = new ArrayList<>();

    public void add(Object o) {
        containers.add(o);
    }

    public int size() {
        return containers.size();
    }
}

