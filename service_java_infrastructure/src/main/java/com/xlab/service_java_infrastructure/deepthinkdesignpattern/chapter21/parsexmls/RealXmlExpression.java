/*
 * module: fundermental
 * file: RealXmlExpression.java
 * date: 8/3/19 5:15 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-03 17:15
 * @desc 处理自定义xml取之表达式的抽象类
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21.parsexmls;

public abstract class RealXmlExpression {

    public abstract String[] interpret(Context context);
}

