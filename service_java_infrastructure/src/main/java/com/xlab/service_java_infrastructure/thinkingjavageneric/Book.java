/*
 * module: fundermental
 * file: Book.java
 * date: 4/30/19 4:51 PM
 * author: VectorJu
 */

/*
 * module: fundermental
 * file: Book.java
 * date: 4/30/19 4:48 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-30 16:48
 * @desc test of finalize
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class Book {

    boolean checkedOut = false;
    Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    protected void finalize() {
        if (checkedOut) {
            System.out.println("Error : checked out ");
            try {
                super.finalize();
                System.out.println("finalize is end ");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}

