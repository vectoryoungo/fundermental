/*
 * module: fundermental
 * file: SubOverrideConcurrentSimulator.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: SubOverrideConcurrentSimulator.java
 * date: 12/26/18 10:43 AM
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-12-26 10:43
 * @desc this is sub of override concurrent simulator
 **/
package com.xlab.service_java_infrastructure.concurrent;

public class SubOverrideConcurrentSimulator extends OverrideConcurrentSimulator{

    synchronized void notifyMsg() {
        System.out.println(" this is sub notifyMsg() ");
        super.notifyMsg();
        System.out.println(" this is end sub notifyMsg() ");
    }
}

