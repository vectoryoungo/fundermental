/*
 * module: fundermental
 * file: LinkListReverse.java
 * date: 3/25/20 5:35 PM
 * author: VectorJu
 */

/**
 * @create 2020-03-25 17:35
 * @desc reverse link list
 **/
package com.xlab.service_java_infrastructure.algorithm;

public class LinkListReverse {


    public static void main(String[] args) {
        Node n1 = new Node(66);
        Node n2 = new Node(77);
        Node n3 = new Node(88);
        Node n4 = new Node(99);

        n1.append(n2).append(n3).append(n4);
        n1.showAllData();
        n1.reverse().showAllData();
    }
}

