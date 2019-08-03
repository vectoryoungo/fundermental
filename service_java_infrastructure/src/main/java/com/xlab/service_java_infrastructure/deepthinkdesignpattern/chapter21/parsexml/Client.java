/*
 * module: fundermental
 * file: Client.java
 * date: 8/3/19 5:47 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-03 17:47
 * @desc use interpret
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexml;

public class Client {

    public static void main(String[] args) {
        Context context = null;
        try {
            context = new Context("service_java_infrastructure/src/main/resources/template.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ElementExpression root = new ElementExpression("root");
        ElementExpression aElement=new ElementExpression("a");
        ElementExpression bElement=new ElementExpression("b");
        ElementExpression cElement = new ElementExpression("c");
        ElementTerminalExpression cElementTerminal=new ElementTerminalExpression("c");
        PropertyTerminalExpression propertyTermial = new PropertyTerminalExpression("name");
        root.addElement(aElement);
        aElement.addElement(bElement);
        bElement.addElement(cElement);
        cElement.addElement(propertyTermial);

        String[] container = root.interpret(context);

        for (String string:container) {
            System.out.println(" the value of container is " + string);
        }

        context.reInit();
        String[] temp = root.interpret(context);
        System.out.println("reInit value is " + temp[0]);



    }
}

