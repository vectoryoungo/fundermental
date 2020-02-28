/*
 * module: fundermental
 * file: American.java
 * date: 2/28/20 2:31 PM
 * author: VectorJu
 */

/**
 * @create 2020-02-28 14:30
 * @desc test cglib proxy
 **/
package com.xlab.service_java_infrastructure.cglib;

import lombok.Data;

@Data
public class American {

    private String identity;
    private String health;

    public void showIdentity(){
        System.out.println(this.identity);
    }

    public void showHealth() {
        System.out.println(" health status "+this.health);
    }
}

