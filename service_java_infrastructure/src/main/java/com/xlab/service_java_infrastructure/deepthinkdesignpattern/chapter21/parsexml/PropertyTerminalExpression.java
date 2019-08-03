/*
 * module: fundermental
 * file: PropertyTerminalExpression.java
 * date: 8/3/19 5:44 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-03 17:43
 * @desc 终结符属性解释器
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexml;

public class PropertyTerminalExpression extends RealXmlExpression {

    private String propertyName;

    public PropertyTerminalExpression(String propertyName) {
        this.propertyName = propertyName;
    }


    @Override
    public String[] interpret(Context context) {

        String[] container = new String[1];
        container[0] = context.getPreElement().getAttribute(propertyName);

        return container;
    }


}

