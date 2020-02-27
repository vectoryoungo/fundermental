/*
 * module: fundermental
 * file: LoadClassFromSpecificPlaceDemo.java
 * date: 2/27/20 8:41 PM
 * author: VectorJu
 */

/**
 * @create 2020-02-27 20:41
 * @desc load class from specific place main class
 **/
package com.xlab.service_java_infrastructure.customerclassloader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;

public class LoadClassFromSpecificPlaceDemo {

    public static void main(String[] args) throws Exception {
        URL path = new File("service_java_infrastructure/com/xlab/service_java_infrastructure/customerclassloader/").toURI().toURL();

        DiskClassLoader diskClassLoaderA = new DiskClassLoader(path);
        Class<?> clazzA = diskClassLoaderA.loadClass("com.xlab.service_java_infrastructure.customerclassloader.BeLoadedClass");
        Method sayA = clazzA.getMethod("say");
        Object instanceA = clazzA.newInstance();
        sayA.invoke(instanceA);
        System.out.println(diskClassLoaderA);
        System.out.println("clazzA@" + clazzA.hashCode());

        System.out.println("====");

        DiskClassLoader diskClassLoaderB = new DiskClassLoader(path, diskClassLoaderA);
        Class<?> clazzB = diskClassLoaderB.loadClass("com.xlab.service_java_infrastructure.customerclassloader.BeLoadedClass");
        Method sayB = clazzB.getMethod("say");
        Object instanceB = clazzA.newInstance();
        sayB.invoke(instanceB);
        System.out.println(diskClassLoaderB);
        System.out.println("clazzB@" + clazzB.hashCode());

        System.out.println("====");

        DiskClassLoader diskClassLoaderC = new DiskClassLoader(path);
        Class<?> clazzC = diskClassLoaderC.loadClass("com.xlab.service_java_infrastructure.customerclassloader.BeLoadedClass");
        Method sayC = clazzC.getMethod("say");
        Object instanceC = clazzC.newInstance();
        sayC.invoke(instanceC);
        System.out.println(diskClassLoaderC);
        System.out.println("clazzC@" + clazzC.hashCode());

        System.out.println("====");

        System.out.println("clazzA == clazzB " + (clazzA == clazzB));
        System.out.println("clazzC == clazzB " + (clazzC == clazzB));
    }
}

