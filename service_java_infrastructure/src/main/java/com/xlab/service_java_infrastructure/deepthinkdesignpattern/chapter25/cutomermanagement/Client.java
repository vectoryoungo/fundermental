/*
 * module: fundermental
 * file: Client.java
 * date: 8/8/19 3:08 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 15:08
 * @desc
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.cutomermanagement;

public class Client {

    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();

        Customer customer = new EnterpriseCustomer();
        customer.setName("WahahaGroup");
        objectStructure.addElement(customer);

        Customer customer1 = new EnterpriseCustomer();
        customer1.setName("MengNiu Group");
        objectStructure.addElement(customer1);

        Customer customer2 = new PersonalCustomer();
        customer2.setName("Smith");
        objectStructure.addElement(customer2);


        ServiceRequestVisitor serviceRequestVisitor = new ServiceRequestVisitor();
        objectStructure.handleRequest(serviceRequestVisitor);

        PredictionAnalyzeVisitor predictionAnalyzeVisitor = new PredictionAnalyzeVisitor();
        objectStructure.handleRequest(predictionAnalyzeVisitor);

    }
}

