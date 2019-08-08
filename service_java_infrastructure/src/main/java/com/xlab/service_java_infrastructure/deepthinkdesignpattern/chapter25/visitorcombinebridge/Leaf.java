/*
 * module: fundermental
 * file: Leaf.java
 * date: 8/8/19 4:22 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 16:22
 * @desc leaf 叶子对象，相当于访问者模式中的具体的Element实现对象
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.visitorcombinebridge;

public class Leaf extends Component {

    private String name = null;


    public Leaf(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitLeaf(this);
    }

}

