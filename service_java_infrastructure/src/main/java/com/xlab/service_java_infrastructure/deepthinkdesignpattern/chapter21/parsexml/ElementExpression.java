/*
 * module: fundermental
 * file: ElementExpression.java
 * date: 8/3/19 5:30 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-03 17:30
 * @desc 非终结符解释器
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexml;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Collection;

public class ElementExpression extends RealXmlExpression{


    private Collection<RealXmlExpression> expressionCollection = new ArrayList<>(16);

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

        Element preElement = context.getPreElement();
        if (preElement == null) {
            //root element
            context.setPreElement(context.getDocument().getDocumentElement());
        }else {
            Element currentElement = context.getCurrentElement(preElement,elementName);
            context.setPreElement(currentElement);
        }

        String[] container = null;

        for (RealXmlExpression realXmlExpression:expressionCollection) {
            container = realXmlExpression.interpret(context);
        }
        return container;
    }

}

