/*
 * module: fundermental
 * file: ElementTerminalExpression.java
 * date: 8/4/19 8:35 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 08:34
 * @desc 终结符元素解释器
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls;

import org.w3c.dom.Element;
import java.util.List;

public class ElementTerminalExpression extends RealXmlExpression{

    private String elementName = "";

    public ElementTerminalExpression(String elementName) {
        this.elementName = elementName;
    }

    @Override
    public String[] interpret(Context context) {
        List<Element> preElements = context.getPreElements();
        Element element = null;
        if (preElements.size() == 0) {
            //root element
            element = context.getDocument().getDocumentElement();
        }else {
            element = context.getCurrentElements(preElements.get(0),elementName).get(0);
        }

        String[] container = new String[1];
        container[0] = element.getFirstChild().getNodeValue();
        return container;
    }
}

