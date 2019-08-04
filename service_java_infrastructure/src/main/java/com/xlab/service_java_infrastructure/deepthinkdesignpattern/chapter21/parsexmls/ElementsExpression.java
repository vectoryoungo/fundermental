/*
 * module: fundermental
 * file: ElementsExpression.java
 * date: 8/4/19 9:12 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 09:12
 * @desc 多个非终结符元素解释器
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ElementsExpression extends RealXmlExpression {

    private Collection<RealXmlExpression> expressionCollection = new ArrayList<>(16);

    private String elementName = "";

    public ElementsExpression(String elementName) {
        this.elementName = elementName;
    }

    @Override
    public String[] interpret(Context context) {

        List<Element> preElement = context.getPreElements();
        List<Element> currentElement = new ArrayList<>(16);

        for (Element e:preElement) {
            currentElement.addAll(context.getCurrentElements(e,elementName));
        }

        context.setPreElements(currentElement);

        String[] container = null;
        for (RealXmlExpression realXmlExpression:expressionCollection) {
            container = realXmlExpression.interpret(context);
        }

        return container;
    }

    public boolean addElement(RealXmlExpression realXmlExpression) {
        expressionCollection.add(realXmlExpression);
        return true;
    }

    public boolean removeElement(RealXmlExpression realXmlExpression) {
        expressionCollection.remove(realXmlExpression);
        return true;
    }


}

