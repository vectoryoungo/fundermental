/*
 * module: fundermental
 * file: AbeInputStream.java
 * date: 3/14/19 11:17 AM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

package com.xlab.service_java_infrastructure.crypto;

import it.unisa.dia.gas.jpbc.Element;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AbeInputStream extends DataInputStream {
    private final String PUB_MISSING_ERROR = "Can't read Elements without the public master key.";

    private AbePublicKey publicKey;

    public AbeInputStream(InputStream in, AbePublicKey publicKey) {
        super(in);
        this.publicKey = publicKey;
    }

    /**
     * If you use this constructor you need to manually set the public key before reading any elements.
     *
     * @param in
     */
    public AbeInputStream(InputStream in) {
        this(in, null);
    }

    public void setPublicKey(AbePublicKey pubKey) {
        this.publicKey = pubKey;
    }

    // only used for the curve parameters and attributes, no need for fancy encodings
    // since internal attribute representation only uses [a-zA-Z0-9:_]
    public String readString() throws IOException {
        int length = readInt();
        byte[] bytes = new byte[length];
        readFully(bytes);
        return new String(bytes, AbeSettings.STRINGS_LOCALE);
    }

    public Element readElement() throws IOException {
        if (publicKey == null) throw new IOException(PUB_MISSING_ERROR);
        int fieldIndex = readInt();
        int length = readInt();
        byte[] bytes = new byte[length];
        readFully(bytes);
        return publicKey.getPairing().getFieldAt(fieldIndex).newElementFromBytes(bytes);
    }
}
