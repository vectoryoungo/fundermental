/*
 * module: fundermental
 * file: Customer.java
 * date: 8/8/19 2:56 PM
 * author: VectorJu
 */

/*
 * module: fundermental
 * file: Customer.java
 * date: 8/8/19 2:53 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 14:53
 * @desc
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.cutomermanagement;

public abstract class Customer {

    private String customerId;
    private String name;


    /**
     * accept visitor visit
     */
    public abstract void accept(Visitor visitor);

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

