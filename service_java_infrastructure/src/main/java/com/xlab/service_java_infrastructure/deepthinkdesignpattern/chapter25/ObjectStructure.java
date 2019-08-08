/*
 * module: fundermental
 * file: ObjectStructure.java
 * date: 8/8/19 11:45 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 11:44
 * @desc 对象结构，通常包含多个被访问的对象,它可以遍历多个被访问的对象，也可以让访问者访问它的元素。可以是一个复合或是一个集合，如一个列表或无序集合。
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25;

import java.util.ArrayList;
import java.util.Collection;

public class ObjectStructure {

    private Collection<Element> collection = new ArrayList<>();

    public void handleRequest(Visitor visitor) {
        for (Element element:collection) {
            element.accept(visitor);
        }
    }

    public void addElement(Element element) {
        collection.add(element);
    }
}

