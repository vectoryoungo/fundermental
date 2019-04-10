/*
 * module: fundermental
 * file: ClassCasting.java
 * date: 4/10/19 3:40 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 15:39
 * @desc test of class casting
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import com.xlab.service_java_infrastructure.thinkingjavageneric.betterfactory.Widget;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ClassCasting {

    public void f(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        //List<Widget> widgetList = List<Widget>.class.cast(in.readObject());// this is illegal
        List<Widget> widgetList1 = List.class.cast(in.readObject());
        System.out.println(widgetList1);
    }

    public static void main(String[] args) {
        ClassCasting classCasting = new ClassCasting();
        try {
            classCasting.f(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

