/*
 * module: fundermental
 * file: LivingBuilding.java
 * date: 5/1/19 6:17 PM
 * author: VectorJu
 */

/**
 * @create 2019-05-01 18:17
 * @desc test of shallow copy
 **/
package com.xlab.service_java_infrastructure.basic;

import java.io.Serializable;

public class LivingBuilding implements Cloneable,Serializable{
    private String buildingName;
    private String buildingLocation;


    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingLocation() {
        return buildingLocation;
    }

    public void setBuildingLocation(String buildingLocation) {
        this.buildingLocation = buildingLocation;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return " buildingName " + buildingName + " buildingLocation " + buildingLocation;
    }
}

