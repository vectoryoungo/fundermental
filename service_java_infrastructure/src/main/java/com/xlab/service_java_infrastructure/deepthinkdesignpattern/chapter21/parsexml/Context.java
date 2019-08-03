/*
 * module: fundermental
 * file: Context.java
 * date: 8/3/19 5:16 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-03 17:16
 * @desc 上下文，用来包含解释器需要的一些全局信息
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Context {

    private Element preElement = null;

    private Document document = null;

    public Context(String filePath) throws Exception{
        document = XmlUtil.getRoot(filePath);
    }

    public void reInit() {
        preElement = null;
    }

    /**
     * get current element
     * @param preElement
     * @param elementName
     * @return current element
     */
    public Element getCurrentElement(Element preElement,String elementName) {

        NodeList tempNodeList = preElement.getChildNodes();
        for (int i=0;i<tempNodeList.getLength();i++){
            if (tempNodeList.item(i) instanceof Element) {
                Element currentElement = (Element) tempNodeList.item(i);
                if (currentElement.getTagName().equals(elementName)) {
                    return currentElement;
                }
            }
        }
        return null;
    }

    public Element getPreElement() {
        return preElement;
    }

    public void setPreElement(Element preElement) {
        this.preElement = preElement;
    }

    public Document getDocument() {
        return document;
    }
}

