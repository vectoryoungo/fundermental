/*
 * module: fundermental
 * file: ClientGetManyProperty.java
 * date: 8/4/19 9:22 AM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 09:22
 * @desc 获取多个属性值测试
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls;

public class ClientGetManyProperty {

    public static void main(String[] args) throws Exception{
        Context context = new Context("service_java_infrastructure/src/main/resources/template.xml");

        ElementExpression root = new ElementExpression("root");
        ElementExpression aElement = new ElementExpression("a");
        ElementExpression bElement = new ElementExpression("b");
        ElementsExpression dElement = new ElementsExpression("d");
        PropertTerminalExpression propertTerminalExpression = new PropertTerminalExpression("id");

        root.addElement(aElement);
        aElement.addElement(bElement);
        bElement.addElement(dElement);
        dElement.addElement(propertTerminalExpression);

        String[] container = root.interpret(context);
        for (String s:container) {
            System.out.println(" d property value is " + s);
        }
    }
}

