/*
 * module: fundermental
 * file: ExceptionSimulator.java
 * date: 9/10/19 9:19 AM
 * author: VectorJu
 */

/**
 * @create 2019-09-10 09:19
 * @desc exception
 **/
package com.xlab.service_java_infrastructure.basic.exception;

public class ExceptionSimulator {

    public static void main(String[] args) {
        Throwable throwable = new Throwable();//this is father class
        Error error = new Error();//Error extends Throwable
        Exception exception = new Exception();//Exception extends Throwable
        error.printStackTrace();
        exception.printStackTrace();
        throwable.printStackTrace();
    }
}

