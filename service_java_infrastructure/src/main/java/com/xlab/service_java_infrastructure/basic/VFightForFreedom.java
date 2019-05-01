/*
 * module: fundermental
 * file: VFightForFreedom.java
 * date: 5/1/19 6:16 PM
 * author: VectorJu
 */

/**
 * @create 2019-05-01 18:16
 * @desc test of copy
 **/
package com.xlab.service_java_infrastructure.basic;

import java.io.*;

public class VFightForFreedom implements Cloneable,Serializable {

    private String name;
    private int age;
    private LivingBuilding home;


    public VFightForFreedom(String name,int age, LivingBuilding home) {
        this.name = name;
        this.age = age;
        this.home = home;
    }

    @Override
    public Object clone() {
        VFightForFreedom v = null;
        try{
             v = (VFightForFreedom) super.clone();
             v.home = (LivingBuilding) home.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return v;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        // 将对象写到流里
        OutputStream bo = new ByteArrayOutputStream();
        //OutputStream op = new ObjectOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(this);

        // 从流里读出来
        InputStream bi = new ByteArrayInputStream(((ByteArrayOutputStream) bo).toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LivingBuilding getHome() {
        return home;
    }

    public void setHome(LivingBuilding home) {
        this.home = home;
    }

    public static void main(String[] args)throws Exception {


        LivingBuilding livingBuilding = new LivingBuilding();
        livingBuilding.setBuildingLocation(" usa california apple one building ");
        livingBuilding.setBuildingName(" apple one building ");

        VFightForFreedom v1 = new VFightForFreedom("Vone",33,livingBuilding);
//        VFightForFreedom v2 = (VFightForFreedom) v1.clone();
        VFightForFreedom v2 = (VFightForFreedom) v1.deepClone();
        v2.home.setBuildingName("shanghai oriental tv tower ");
        v2.home.setBuildingLocation("shanghai pudong district ");
        v2.setAge(40);
        v2.setName("Vtwo");

        System.out.println("age "  + v1.age + " name " + v1.name + " home " + v1.home);
        System.out.println("age "  + v2.age + " name " + v2.name + " home " + v2.home);
    }

}

