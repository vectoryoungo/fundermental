/*
 * module: fundermental
 * file: Visitor.java
 * date: 8/8/19 4:03 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 16:03
 * @desc 访问组合对象结构的访问者接口
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.visitorcombinebridge;

public interface Visitor {

    public void visitComposite(Composite composite);
    public void visitLeaf(Leaf leaf);
}

