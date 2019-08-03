/*
 * module: fundermental
 * file: XmlUtil.java
 * date: 8/3/19 5:18 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-03 17:18
 * @desc xml util
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexml;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlUtil {

    public static Document getRoot(String filePath) throws Exception {
        Document document = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.parse(filePath);
        document.normalizeDocument();
        return document;
    }
}

