/*
 * module: fundermental
 * file: PrivateLockProtectState.java
 * date: 6/7/20 5:17 PM
 * author: VectorJu
 */

/**
 * @create 2020-06-07 17:17
 * @desc 使用私有锁保护状态
 **/
package com.xlab.service_java_infrastructure.concurrent;

import apple.laf.JRSUIConstants;

public class PrivateLockProtectState {

    private final Object myLock = new Object();

    JRSUIConstants.Widget widget;

    void someMethod() {
        synchronized (myLock) {
            //访问或修改widget的状态
            widget.apply(1);
        }
    }
}

