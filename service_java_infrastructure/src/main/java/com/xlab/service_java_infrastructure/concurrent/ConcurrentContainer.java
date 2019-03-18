/*
 * module: fundermental
 * file: ConcurrentContainer.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

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

