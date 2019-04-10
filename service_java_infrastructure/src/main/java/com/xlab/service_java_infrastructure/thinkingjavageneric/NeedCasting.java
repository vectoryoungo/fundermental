/*
 * module: fundermental
 * file: NeedCasting.java
 * date: 4/10/19 3:37 PM
 * author: VectorJu
 */

/**
 * @create 2019-04-10 15:37
 * @desc test of generic
 **/
package com.xlab.service_java_infrastructure.thinkingjavageneric;

import com.xlab.service_java_infrastructure.thinkingjavageneric.betterfactory.Widget;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class NeedCasting {
    public void f(String[] arg)throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(arg[0]));
        List<Widget> shapes = (List<Widget>)in.readObject();
    }
}

