/*
 * module: fundermental
 * file: PrintNameVisitor.java
 * date: 8/8/19 4:25 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 16:25
 * @desc 具体的访问者，实现：输出对象的名称，在组合对象的名称前面添加"节点："，在叶子对象的名称前添加"叶子："
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.visitorcombinebridge;

public class PrintNameVisitor implements Visitor{


    @Override
    public void visitComposite(Composite composite) {
        //access composite object data
        System.out.println("节点：" + composite.getName());
    }

    @Override
    public void visitLeaf(Leaf leaf) {
        //access leaf object data
        System.out.println("叶子："+leaf.getName());

    }
}

