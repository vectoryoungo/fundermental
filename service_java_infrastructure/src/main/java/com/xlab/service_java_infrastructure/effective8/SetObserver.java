/*
 * module: fundermental
 * file: SetObserver.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 *
 *
 */

/*
 * module: fundermental
 * file: SetObserver.java
 * date: 18-8-26 下午4:33
 * author: VectorJu
 */

/**
 * @author juhongtao
 * @create 2018-08-26 16:33
 * @desc functional interface
 **/
package com.xlab.service_java_infrastructure.effective8;

@FunctionalInterface
public interface SetObserver<E> {
    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}

