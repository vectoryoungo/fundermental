/*
 * module: fundermental
 * file: UserThreadFactory.java
 * date: 3/27/19 4:32 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-27 16:31
 * @desc UserThreadFactory
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class UserThreadFactory implements ThreadFactory{

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger();

    UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "UserThreadFactory's " + whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {

        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null,task,name,0);
        System.out.println(thread.getName());
        return thread;
    }
}

