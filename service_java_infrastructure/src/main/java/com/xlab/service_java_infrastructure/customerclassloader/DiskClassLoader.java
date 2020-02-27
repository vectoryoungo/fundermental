/*
 * module: fundermental
 * file: DiskClassLoader.java
 * date: 2/27/20 8:39 PM
 * author: VectorJu
 */

/**
 * @create 2020-02-27 20:38
 * @desc test classloader load class from specific place
 **/
package com.xlab.service_java_infrastructure.customerclassloader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class DiskClassLoader extends URLClassLoader{

    public DiskClassLoader(URL path) throws MalformedURLException {
        super(new URL[]{path});
    }

    public DiskClassLoader(URL path, ClassLoader parent) throws MalformedURLException {
        super(new URL[]{path}, parent);
    }
}

