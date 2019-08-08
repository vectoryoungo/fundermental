/*
 * module: fundermental
 * file: EnterpriseCustomer.java
 * date: 8/8/19 2:57 PM
 * author: VectorJu
 */

/**
 * @create 2019-08-08 14:57
 * @desc enterprise
 **/
package com.xlab.service_java_infrastructure.deepthinkdesignpattern.chapter25.cutomermanagement;

public class EnterpriseCustomer extends Customer {

    private String contactMan;
    private String contactTelephone;
    private String registerAddress;

    @Override
    public void accept(Visitor visitor) {
        //callback visitor method
        visitor.visitEnterpriseCustomer(this);
    }


    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }
}

