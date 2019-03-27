/*
 * module: fundermental
 * file: UserRejectHandler.java
 * date: 3/27/19 4:10 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-27 16:10
 * @desc UserRejectHandler
 * custom handler process reject policy
 **/
package com.xlab.service_java_infrastructure.easycoding;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class UserRejectHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(" Task Has been rejected!!! plz check out ");
    }
}

