/*
 * module: fundermental
 * file: ElementsTerminalExpression.java
 * date: 8/4/19 9:08 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 09:08
 * @desc 多个元素终结符解释器
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class ElementsTerminalExpression extends RealXmlExpression {

    private String elementName = "";

    public ElementsTerminalExpression(String elementName) {
        this.elementName = elementName;
    }

    @Override
    public String[] interpret(Context context) {

        List<Element> preElement = context.getPreElements();
        List<Element> currentElement = new ArrayList<>(16);

        for (Element element:preElement) {
            currentElement.addAll(context.getCurrentElements(element,elementName));
        }

        String[] container = new String[currentElement.size()];
        for (int i=0;i<container.length;i++) {
            container[i] = currentElement.get(i).getFirstChild().getNodeValue();
        }

        return container;
    }
}

