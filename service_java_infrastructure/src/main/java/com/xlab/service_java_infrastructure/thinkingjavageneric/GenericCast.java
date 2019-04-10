/*
 * module: fundermental
 * file: GenericCast.java
 * date: 4/10/19 3:29 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 15:29
 * @desc test of generic cast
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class GenericCast {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixSizeStack<String> stringFixSizeStack = new FixSizeStack<>(SIZE);

        for (String s : "A B C D E F G H I J".split(" ")) {
            stringFixSizeStack.push(s);
        }

        for (int i=0;i<SIZE;i++){
            String s = stringFixSizeStack.pop();
            System.out.print(s + " ");
        }
    }
}

