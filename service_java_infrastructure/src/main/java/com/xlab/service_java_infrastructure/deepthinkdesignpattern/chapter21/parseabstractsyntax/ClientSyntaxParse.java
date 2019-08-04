/*
 * module: fundermental
 * file: ClientSyntaxParse.java
 * date: 8/4/19 12:02 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-04 12:02
 * @desc client
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parseabstractsyntax;

import com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls.Context;
import com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls.RealXmlExpression;

public class ClientSyntaxParse {

    public static void main(String[] args) throws Exception{
        Context context = new Context("service_java_infrastructure/src/main/resources/template.xml");
        RealXmlExpression realXmlExpression = Parser.parse("root/a/b/d$.id$");
        String[] container = realXmlExpression.interpret(context);

        for (String content:container) {
            System.out.println("d property id value is " + content);
        }

        context.reInit();
        RealXmlExpression realXmlExpression1 = Parser.parse("root/a/b/d$");
        String[] containerT = realXmlExpression1.interpret(context);
        for (String s:containerT){
            System.out.println("d value is " +s);
        }
    }
}

