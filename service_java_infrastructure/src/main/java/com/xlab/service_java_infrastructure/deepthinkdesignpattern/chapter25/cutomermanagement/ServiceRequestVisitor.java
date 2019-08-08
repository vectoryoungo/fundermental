/*
 * module: fundermental
 * file: ServiceRequestVisitor.java
 * date: 8/8/19 3:03 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 15:03
 * @desc service request visitor
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.cutomermanagement;

public class ServiceRequestVisitor implements Visitor {
    @Override
    public void visitEnterpriseCustomer(EnterpriseCustomer enterpriseCustomer) {
        System.out.println(enterpriseCustomer.getName() + " ServiceRequestVisitor accept visitEnterpriseCustomer");
    }

    @Override
    public void visitPersonalCustomer(PersonalCustomer personalCustomer) {
        System.out.println(personalCustomer.getName() + " ServiceRequestVisitor accept visitPersonalCustomer");
    }
}

