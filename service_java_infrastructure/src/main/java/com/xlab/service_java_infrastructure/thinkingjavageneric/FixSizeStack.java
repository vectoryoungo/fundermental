/*
 * module: fundermental
 * file: FixSizeStack.java
 * date: 4/10/19 3:27 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 15:27
 * @desc test of convation
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class FixSizeStack<T> {
    private int index = 0;
    private Object[] storage;

    public FixSizeStack(int size) {
        storage = new Object[size];
    }

    public void push(T item) {
        storage[index++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return (T) storage[--index];
    }
}

