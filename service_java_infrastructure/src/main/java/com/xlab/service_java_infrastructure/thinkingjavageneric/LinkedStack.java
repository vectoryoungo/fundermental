/*
 * module: fundermental
 * file: LinkedStack.java
 * date: 4/7/19 5:54 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-07 17:54
 * @desc thinking in java linkedstatck test
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class LinkedStack<T> {

    private static class Node<U> {
        U item;
        Node<U> next;
        Node(){
            item = null;
            next = null;
        }

        Node(U item,Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();

    public void push(T item) {
        top = new Node<T>(item,top);
    }

    public T pop() {
        T result = top.item;

        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<String>();
        for (String string: "Phasers or stun !".split(" ")) {
            linkedStack.push(string);
        }

        String s = null;
        while ((s = linkedStack.pop()) != null) {
            System.out.println(s);
        }
    }


}

