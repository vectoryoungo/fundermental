/*
 * module: fundermental
 * file: StaticExceptionSimulator.java
 * date: 4/20/20 11:40 PM
 * author: VectorJu
 */

/**
 * @create 2020-04-20 23:40
 * @desc simulate generic exception
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

/**
 * 运行结果是2
 * 由于经过类型擦除，所有的泛型类实例都关联到同一份字节码上，泛型类的所有静态变量是共享的。
 */
public class StaticExceptionSimulator {

    public static void main(String[] args){
        GT<Integer> gti = new GT<Integer>();
        gti.var=1;
        GT<String> gts = new GT<String>();
        gts.var=2;
        System.out.println(gti.var);
    }

    static class GT<T>{
        public static int var=0;
        public void nothing(T x){}
    }
}

