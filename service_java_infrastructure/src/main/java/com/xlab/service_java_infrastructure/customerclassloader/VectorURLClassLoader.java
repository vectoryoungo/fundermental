package com.xlab.service_java_infrastructure.customerclassloader;

import java.net.URL;
import java.net.URLClassLoader;

public class VectorURLClassLoader extends URLClassLoader {

    private String packageName = "your.name.classPackage";

    public VectorURLClassLoader(URL[] classPath, ClassLoader parent) {
        super(classPath,parent);
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> aClass = findLoadedClass(name);
        if (aClass!=null){
            return aClass;
        }
        if (packageName.startsWith(name)){
            return super.loadClass(name);
        }else {
            return findClass(name);
        }
    }
}
