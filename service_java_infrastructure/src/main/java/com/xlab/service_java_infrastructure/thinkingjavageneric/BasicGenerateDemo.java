/*
 * module: fundermental
 * file: BasicGenerateDemo.java
 * date: 4/8/19 8:21 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-08 08:21
 * @desc test BasicGenerator
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

public class BasicGenerateDemo {

    public static void main(String[] args) {
//        BasicGenerator<CountedObject>
        Generator<CountedObject> countedObjectGenerator = BasicGenerator.create(CountedObject.class);

        for (int i =0;i<5;i++) {
            System.out.println(countedObjectGenerator.next());
        }
    }
}

