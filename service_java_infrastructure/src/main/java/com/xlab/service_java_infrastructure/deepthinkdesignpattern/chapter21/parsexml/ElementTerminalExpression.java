/*
 * module: fundermental
 * file: ElementTerminalExpression.java
 * date: 8/3/19 5:37 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-03 17:37
 * @desc 终结符对应的解释器
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexml;

import org.w3c.dom.Element;

public class ElementTerminalExpression extends RealXmlExpression {


    private String elementName = "";

    public ElementTerminalExpression(String elementName) {
        this.elementName = elementName;
    }

    @Override
    public String[] interpret(Context context) {

        Element preElement = context.getPreElement();
        Element element = null;
        if (preElement == null) {
            element = context.getDocument().getDocumentElement();
            context.setPreElement(element);
        }else {
            element = context.getCurrentElement(preElement,elementName);
            context.setPreElement(element);
        }

        String[] container = new String[1];
        container[0] = element.getFirstChild().getNodeValue();

        return container;
    }
}

