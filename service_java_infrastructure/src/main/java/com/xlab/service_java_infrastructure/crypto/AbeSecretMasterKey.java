/*
 * module: fundermental
 * file: AbeSecretMasterKey.java
 * date: 3/14/19 11:24 AM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

package com.xlab.service_java_infrastructure.crypto;

import it.unisa.dia.gas.jpbc.Element;

import java.io.*;

/**
 * A master secret key
 */
public class AbeSecretMasterKey {

    /**
     * Zr
     **/
    public Element beta;
    /**
     * G2
     **/
    public Element g_alpha;
    private AbePublicKey pubKey;

    public AbeSecretMasterKey(AbePublicKey pubKey, Element beta, Element g_alpha) {
        this.pubKey = pubKey;
        this.beta = beta;
        this.g_alpha = g_alpha;
    }

    public static AbeSecretMasterKey readFromStream(InputStream stream) throws IOException {
        AbeInputStream abeStream = new AbeInputStream(stream);
        AbePublicKey pubKey = AbePublicKey.readFromStream(abeStream);
        abeStream.setPublicKey(pubKey);
        Element betaIn = abeStream.readElement();
        Element g_alphaIn = abeStream.readElement();
        return new AbeSecretMasterKey(pubKey, betaIn, g_alphaIn);
    }

    public static AbeSecretMasterKey readFromFile(File file) throws IOException {
        try (FileInputStream stream = new FileInputStream(file)) {
            return readFromStream(stream);
        }
    }

    public static AbeSecretMasterKey readFromByteArray(byte[] data) throws IOException {
        try (ByteArrayInputStream stream = new ByteArrayInputStream(data)) {
            return readFromStream(stream);
        }
    }

    public AbePublicKey getPublicKey() {
        return pubKey;
    }

    public void writeToFile(File file) throws IOException {
        try (AbeOutputStream fileStream = new AbeOutputStream(new FileOutputStream(file), pubKey)) {
            writeToStream(fileStream);
        }
    }

    private void writeToStream(OutputStream stream) throws IOException {
        writeToStream(new AbeOutputStream(stream, pubKey));
    }

    public void writeToStream(AbeOutputStream stream) throws IOException {
        pubKey.writeToStream(stream);
        stream.writeElement(beta);
        stream.writeElement(g_alpha);
    }

    public byte[] getAsByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        this.writeToStream(baos);
        return baos.toByteArray();
    }
}
