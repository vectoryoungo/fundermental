/*
 * module: fundermental
 * file: DataHandler.java
 * date: 3/9/20 9:21 AM
 * author: VectorJu
 */

/**
 * @create 2020-03-09 09:21
 * @desc process html file
 **/
package com.xlab.service_java_infrastructure.dataprocess;


import java.io.*;
import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;


public class DataHandler {

        public static void main(String[] args) throws IOException {
            Document document = Jsoup.parse(new File("hello"),"GB18030");
            Elements elements = document.getElementsByTag("table");
            for (Element element:elements) {
                Elements trs = element.getElementsByTag("tr");
                for (Element bodyElement:trs) {
                    //第一行
                    Elements tdElements = bodyElement.getElementsByTag("td");
                    for (Element elementTD:tdElements) {
                        //第一列
                        Elements bElementContent = elementTD.getElementsByTag("b");
                        if (bElementContent != null) {
                            for (Element elementB:bElementContent) {
                                List<Node> elementBContent = elementB.childNodes();
                                int size = elementBContent.size();
                                System.out.println(" elementBContent size "+size);
                                if (size > 0) {
                                    for (Node node:elementBContent) {
                                        System.out.println(" node is " +  node.toString());
                                    }
                                }

                            }
                        }else {
                            String tdData = elementTD.data();
                            System.out.println(" td data is "+tdData);
                        }

                    }
                }
            }
        }
}


