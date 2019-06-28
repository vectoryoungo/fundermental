/*
 * module: fundermental
 * file: GzipUtils.java
 * date: 6/28/19 11:13 AM
 * author: VectorJu
 */

/**
 * @create 2019-06-28 11:12
 * @desc zip and unzip
 **/
package com.xlab.service_java_infrastructure.architecture.netty.serilize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtils {

    public static byte[] unzip(byte[] source) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(source);
        try {
            GZIPInputStream gzipInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] container = new byte[256];
            int lenght = 0;
            while((lenght = gzipInputStream.read(container,0,container.length))!=-1) {
                byteArrayOutputStream.write(container, 0,lenght);
            }

            byte[] target = byteArrayOutputStream.toByteArray();
            gzipInputStream.close();
            byteArrayOutputStream.close();
            return target;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] zip(byte[] source) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gzgzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gzgzipOutputStream.write(source);
            gzgzipOutputStream.finish();
            byte[] target = byteArrayOutputStream.toByteArray();
            gzgzipOutputStream.close();
            return target;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

