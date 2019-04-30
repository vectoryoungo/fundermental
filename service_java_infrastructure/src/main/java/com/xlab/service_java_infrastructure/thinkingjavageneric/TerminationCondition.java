/*
 * module: fundermental
 * file: TerminationCondition.java
 * date: 4/30/19 4:51 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-30 16:51
 * @desc test termination
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class TerminationCondition {

    public static void main(String[] args) {
        Book book = new Book(true);

        book.checkIn();

        new Book(true);

        System.gc();
    }
}

