package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter23;


/**
 * 实现职责的类，在这个类中，实现对在它职责范围内请求的处理，如果不处理，就继续转发请求给后继者。
 */
public class ConcreteHandler extends Handler{

    @Override
    public void handleRequest() {

        //according to some condition figure out is this need to be process or not
        boolean someCondition = false;

        //if this need to be process then do process here
        if (someCondition) {
            //do something
        }else {
            //if this is not belong to this hanlder then figure out is there any other hanlder
            //if have then request or do nothing
            if (successor!=null) {
                successor.handleRequest();
            }
        }
    }
}
