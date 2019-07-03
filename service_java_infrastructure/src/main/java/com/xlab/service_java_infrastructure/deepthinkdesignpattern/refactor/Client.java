/*
 * module: fundermental
 * file: Client.java
 * date: 4/7/19 10:02 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 10:01
 * @desc client of test factory
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.refactor;

public class Client {

    public static void main(String[] args) {
        Api api = Factory.createApi(1);
        api.operation("using simple factory ...");
    }
}

