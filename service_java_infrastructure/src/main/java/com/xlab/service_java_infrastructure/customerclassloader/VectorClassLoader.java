package com.xlab.service_java_infrastructure.customerclassloader;

import java.io.*;

public class VectorClassLoader extends ClassLoader {
    private String classPath;
    private String packageName;


    public VectorClassLoader(String classPath,String packageName) {
        this.classPath = classPath;
        this.packageName = packageName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        if (packageName.startsWith(name)){
            byte[] classData = getData(name);
            if (classData!=null){
                return  defineClass(name,classData,0,classData.length);
            }
            else {
                throw new ClassNotFoundException();
            }
        } else {
            return super.loadClass(name);
        }
    }

    private byte[] getData(String className) {
        String path = classPath+ File.separatorChar+className.replace('.',File.separatorChar)+".class";
        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num =0;
            while ((num=is.read(buffer))!=-1){
                stream.write(buffer,0,num);
            }
            return stream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
