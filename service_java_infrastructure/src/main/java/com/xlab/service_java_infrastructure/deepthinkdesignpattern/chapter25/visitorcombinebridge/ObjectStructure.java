/*
 * module: fundermental
 * file: ObjectStructure.java
 * date: 8/8/19 4:27 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 16:27
 * @desc 对象结构，通常在这里对元素对象进行遍历，让访问者能够访问到所有的元素
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.visitorcombinebridge;

public class ObjectStructure {

    //this is object structure it could be a list or set
    private Component root  = null;

    public void handleRequest(Visitor visitor) {
        if (root !=null) {
            root.accept(visitor);
        }
    }

    public void setRoot(Component element) {
        root = element;
    }

}

