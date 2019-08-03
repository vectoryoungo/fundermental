/*
 * module: fundermental
 * file: AbstractExpression.java
 * date: 8/3/19 4:42 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-03 16:42
 * @desc 定义解释器的接口，约定解释器的解释操作
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter21;

public abstract class AbstractExpression {
    public abstract void interpret(Context context);
}

