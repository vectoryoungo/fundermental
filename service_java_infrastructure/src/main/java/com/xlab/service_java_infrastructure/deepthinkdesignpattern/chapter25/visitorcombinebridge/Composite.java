/*
 * module: fundermental
 * file: Composite.java
 * date: 8/8/19 4:05 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 16:04
 * @desc 组合对象，可以包含其他组合对象或叶子对象，相当于访问者模式的具体Element实现对象
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.visitorcombinebridge;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{

    private List<Component> childComponents = new ArrayList<>();
    private String name = null;


    public Composite(String name) {
        this.name = name;
    }

    public void addChild(Component child) {
        childComponents.add(child);
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitComposite(this);
        for (Component component:childComponents) {
            component.accept(visitor);
        }
    }
}

