/*
 * module: fundermental
 * file: Context.java
 * date: 8/3/19 11:02 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-03 23:02
 * @desc 上下文，用来包含解释器需要的一些全局信息
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls;

import com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexml.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Context {

    private Document document = null;

    private List<Element> preElements = new ArrayList<>();

    public Context(String filePath) throws Exception{
        document = XmlUtil.getRoot(filePath);
    }

    public void reInit() {
        preElements = new ArrayList<>();
    }

    /**
     * get current element arrays according to preElement and elementName
     * @param preElement
     * @param elementName
     * @return
     */
    public List<Element> getCurrentElements(Element preElement,String elementName) {
        List<Element> elements = new ArrayList<>();
        NodeList nodeList = preElement.getChildNodes();
        for (int i=0;i<nodeList.getLength();i++){
            if (nodeList.item(i) instanceof Element) {
                Element currentElement = (Element) nodeList.item(i);
                if (currentElement.getTagName().equals(elementName)) {
                    elements.add(currentElement);
                }
            }
        }
        return elements;
    }

    public Document getDocument() {
        return document;
    }

    public List<Element> getPreElements() {
        return preElements;
    }

    public void setPreElements(List<Element> preElements) {
        this.preElements = preElements;
    }
}

