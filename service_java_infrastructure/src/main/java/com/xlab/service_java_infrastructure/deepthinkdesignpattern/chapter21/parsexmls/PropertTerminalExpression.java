/*
 * module: fundermental
 * file: PropertTerminalExpression.java
 * date: 8/4/19 8:39 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 08:39
 * @desc 多元素属性终结符解释器
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls;

import org.w3c.dom.Element;

import java.util.List;

public class PropertTerminalExpression extends RealXmlExpression {


    private String propertyName;

    public PropertTerminalExpression(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public String[] interpret(Context context) {

        List<Element> elementList = context.getPreElements();

        String[] container = new String[elementList.size()];

        for (int i=0;i<container.length;i++) {
            container[i] = elementList.get(i).getAttribute(propertyName);
        }
        return container;
    }
}

