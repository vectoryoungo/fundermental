/*
 * module: fundermental
 * file: ObjectStructure.java
 * date: 8/8/19 3:02 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 15:02
 * @desc objectstructure
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.cutomermanagement;

import java.util.ArrayList;
import java.util.Collection;

public class ObjectStructure {

    private Collection<Customer> customerCollection = new ArrayList<>();

    /**
     * provided for client operate this method
     * @param visitor
     */
    public void handleRequest(Visitor visitor) {
        for (Customer customer:customerCollection){
            customer.accept(visitor);
        }
    }

    /**
     * combine objectStructure ,add customer to customer collection
     * @param customer
     */
    public void addElement(Customer customer) {
        customerCollection.add(customer);
    }
}

