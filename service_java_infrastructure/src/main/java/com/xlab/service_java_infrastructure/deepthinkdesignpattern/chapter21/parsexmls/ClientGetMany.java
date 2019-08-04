/*
 * module: fundermental
 * file: ClientGetMany.java
 * date: 8/4/19 9:17 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 09:17
 * @desc 测试获取多个元素
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls;

public class ClientGetMany {

    public static void main(String[] args)throws Exception {
        Context context = new Context("service_java_infrastructure/src/main/resources/template.xml");
        ElementExpression root = new ElementExpression("root");
        ElementExpression aElement = new ElementExpression("a");
        ElementExpression bElement = new ElementExpression("b");
        ElementsTerminalExpression dElement = new ElementsTerminalExpression("d");

        root.addElement(aElement);
        aElement.addElement(bElement);
        bElement.addElement(dElement);

        String[] container = root.interpret(context);

        for (String s:container) {
            System.out.println(" element d is " + s);
        }
    }
}

