/*
 * module: fundermental
 * file: Factory.java
 * date: 4/7/19 9:59 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 09:59
 * @desc factory provide obtain api's instance
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.refactor;

public class Factory {

    public static Api createApi(int condition) {

        Api api = null;

        if (condition == 1) {
            api = new ImplA();
        } else if (condition == 2) {
            api = new ImplB();
        }

        return api;
    }
}

