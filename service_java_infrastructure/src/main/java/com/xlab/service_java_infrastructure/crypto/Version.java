/*
 * module: fundermental
 * file: Version.java
 * date: 3/14/19 11:33 AM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

package com.xlab.service_java_infrastructure.crypto;

import java.io.IOException;
import java.util.Arrays;

public class Version {
    public final static int MAJOR_VERSION = 1;
    public final static int MINOR_VERSION = 0;
    public final static byte[] MAGIC_BYTES = {'J', 'C', 'P', 'A', 'B', 'E'};

    public static void readAndVerify(AbeInputStream inputStream) throws IOException {
        byte[] magicBytes = new byte[MAGIC_BYTES.length];
        inputStream.readFully(magicBytes);
        if (!Arrays.equals(magicBytes, MAGIC_BYTES))
            throw new IOException("Invalid magic bytes: probably not a JCPABE file");
        int majorVersion = inputStream.readInt();
        int minorVersion = inputStream.readInt();
        if (majorVersion != MAJOR_VERSION || minorVersion != MINOR_VERSION)
            throw new IOException("Unsupported version of ABE files");
    }

    public static void writeToStream(AbeOutputStream outputStream) throws IOException {
        outputStream.write(MAGIC_BYTES);
        outputStream.writeInt(MAJOR_VERSION);
        outputStream.writeInt(MINOR_VERSION);
    }
}
