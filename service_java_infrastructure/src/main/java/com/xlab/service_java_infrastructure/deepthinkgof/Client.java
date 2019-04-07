/*
 * module: fundermental
 * file: Client.java
 * date: 4/7/19 9:44 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 09:43
 * @desc test of deepthinkpattern client
 **/
package com.xlab.service_java_infrastructure.deepthinkgof;

import org.springframework.beans.factory.FactoryBean;

public class Client {

    public static void main(String[] args) {
        Api api = new Impl();
        api.test1("just a test for api ");
    }
}

