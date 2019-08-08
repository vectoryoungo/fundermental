/*
 * module: fundermental
 * file: PredictionAnalyzeVisitor.java
 * date: 8/8/19 3:05 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 15:05
 * @desc
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.cutomermanagement;

public class PredictionAnalyzeVisitor implements Visitor {
    @Override
    public void visitEnterpriseCustomer(EnterpriseCustomer enterpriseCustomer) {
        System.out.println(enterpriseCustomer.getName() + " PredictionAnalyzeVisitor accept visitEnterpriseCustomer");
    }

    @Override
    public void visitPersonalCustomer(PersonalCustomer personalCustomer) {
        System.out.println(personalCustomer.getName() + " PredictionAnalyzeVisitor accept visitPersonalCustomer");
    }
}

