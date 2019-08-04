/*
 * module: fundermental
 * file: Parser.java
 * date: 8/4/19 11:21 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 11:20
 * @desc 根据语法来解析表达式，转换成对应的抽象语法树
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parseabstractsyntax;

import com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls.*;

import java.util.*;

public class Parser {

    private Parser() {

    }

    private final static String BACKLASH = "/";
    private final static String DOT = ".";
    private final static String DOLLAR = "$";

    private static List<String> listElement = null;

    public static RealXmlExpression parse(String expression) {

        listElement = new ArrayList<>(16);
        Map<String,ParseModel> mapPath = parseMapPath(expression);
        List<RealXmlExpression> list = mapPath2Interpreter(mapPath);
        RealXmlExpression realXmlExpression = buildTree(list);

        return realXmlExpression;
    }

    private static Map<String,ParseModel> parseMapPath(String expression) {

        StringTokenizer tokenizer = new StringTokenizer(expression,BACKLASH);

        Map<String,ParseModel> mapPath = new HashMap<>(16);

        while (tokenizer.hasMoreTokens()) {
            String onePath = tokenizer.nextToken();

            if (tokenizer.hasMoreTokens()) {
                setParsePath(false,onePath,false,mapPath);
            }else {
                int dotIndex = onePath.indexOf(DOT);
                if (dotIndex > 0) {
                    String elementName = onePath.substring(0,dotIndex);
                    String propName = onePath.substring(dotIndex+1);
                    setParsePath(false,elementName,false,mapPath);
                    setParsePath(true,propName,true,mapPath);
                }else {
                    setParsePath(true,onePath,false,mapPath);
                }
            }
        }

        return mapPath;
    }

    private static void setParsePath(boolean end,String element,boolean propertyValue,Map<String,ParseModel> mapPath) {

        ParseModel parseModel = new ParseModel();

        parseModel.setEnd(end);
        parseModel.setSingleValue(!(element.indexOf(DOLLAR)>0));
        parseModel.setPropertyValue(propertyValue);
        element = element.replace(DOLLAR,"");
        mapPath.put(element,parseModel);
        listElement.add(element);
    }

    /**
     * after parse element and convert element name into Interpreter
     * @param mapPath
     * @return List<RealXmlExpression>
     */
    private static List<RealXmlExpression> mapPath2Interpreter(Map<String,ParseModel> mapPath) {

        List<RealXmlExpression> list = new ArrayList<>(16);
        for (String key:listElement) {
            ParseModel parseModel = mapPath.get(key);
            RealXmlExpression realXmlExpression = null;
            if (!parseModel.isEnd()) {
                if (parseModel.isSingleValue()) {
                    realXmlExpression = new ElementExpression(key);
                }else {
                    realXmlExpression = new ElementsExpression(key);
                }
            }else {
                if (parseModel.isPropertyValue()) {
                    if (parseModel.isSingleValue()) {
                        realXmlExpression = new PropertyTerminalExpression(key);
                    }else {
                        realXmlExpression = new PropertTerminalExpression(key);
                    }
                }else {
                    if (parseModel.isSingleValue()) {
                        realXmlExpression = new ElementTerminalExpression(key);
                    }else {
                        realXmlExpression = new ElementsTerminalExpression(key);
                    }
                }
            }

            list.add(realXmlExpression);
        }

        return list;
    }

    private static RealXmlExpression buildTree(List<RealXmlExpression> realXmlExpressionList) {
        RealXmlExpression realXmlExpression = null;
        RealXmlExpression preRealXmlExpression = null;

        for (RealXmlExpression xmlExpression:realXmlExpressionList) {
            if (preRealXmlExpression == null) {
                preRealXmlExpression = xmlExpression;
                realXmlExpression = xmlExpression;
            }else {
                if (preRealXmlExpression instanceof ElementExpression) {
                    ElementExpression elementExpression = (ElementExpression) preRealXmlExpression;
                    elementExpression.addElement(xmlExpression);
                    preRealXmlExpression = xmlExpression;
                }else if (preRealXmlExpression instanceof  ElementsExpression) {
                    ElementsExpression elementsExpression = (ElementsExpression) preRealXmlExpression;
                    elementsExpression.addElement(xmlExpression);
                    preRealXmlExpression = xmlExpression;
                }
            }
        }

        return realXmlExpression;
    }
}

