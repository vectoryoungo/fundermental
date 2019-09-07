/*
 * module: fundermental
 * file: World.java
 * date: 9/6/19 10:56 AM
 * author: VectorJu
 */

/**
 * @create 2019-09-06 10:56
 * @desc world object of test oom
 **/
package com.xlab.service_java_infrastructure.basic.oom;

import java.util.ArrayList;
import java.util.List;

public class World {

    private Object object;
    private String diversion;
    private int diversity;
    //private List<Object> contains = new ArrayList<>(1000);


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getDiversion() {
        return diversion;
    }

    public void setDiversion(String diversion) {
        this.diversion = diversion;
    }
/*

    public List<Object> getContains() {
        return contains;
    }

    public void setContains(List<Object> contains) {
        this.contains = contains;
    }
*/

    public int getDiversity() {
        return diversity;
    }

    public void setDiversity(int diversity) {
        this.diversity = diversity;
    }
}

