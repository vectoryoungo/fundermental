/*
 * module: fundermental
 * file: Visitor.java
 * date: 8/8/19 2:56 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 14:56
 * @desc visitor
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.cutomermanagement;

public interface Visitor {

    public void visitEnterpriseCustomer(EnterpriseCustomer enterpriseCustomer);
    public void visitPersonalCustomer(PersonalCustomer personalCustomer);
}

