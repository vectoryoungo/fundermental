/*
 * module: fundermental
 * file: ElementExpression.java
 * date: 8/3/19 11:11 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-03 23:11
 * @desc 单个元素非终结解释器
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ElementExpression extends RealXmlExpression {

    private Collection<RealXmlExpression> expressionCollection = new ArrayList<>();

    private String elementName = "";

    public ElementExpression(String elementName) {
        this.elementName = elementName;
    }

    public boolean addElement(RealXmlExpression realXmlExpression) {
        expressionCollection.add(realXmlExpression);
        return true;
    }

    public boolean removeElement(RealXmlExpression realXmlExpression) {
        expressionCollection.remove(realXmlExpression);
        return true;
    }

    @Override
    public String[] interpret(Context context) {

        List<Element> preElements = context.getPreElements();

        Element element = null;
        List<Element> currentElements = new ArrayList<>(16);
        if (preElements.size() == 0) {
            element = context.getDocument().getDocumentElement();
            preElements.add(element);
            context.setPreElements(preElements);
        }else {
            for (Element elementT:preElements) {
                currentElements.addAll(context.getCurrentElements(elementT,elementName));
                if (currentElements.size() > 0) {
                    break;
                }
            }

            List<Element> tempList = new ArrayList<>();
            tempList.add(currentElements.get(0));
            context.setPreElements(tempList);
        }

        String[] container = null;
        for (RealXmlExpression realXmlExpression:expressionCollection) {
            container = realXmlExpression.interpret(context);
        }

        return container;
    }
}

