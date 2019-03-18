/*
 * module: fundermental
 * file: AbeOutputStream.java
 * date: 3/14/19 11:17 AM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

package com.xlab.service_java_infrastructure.crypto;

import it.unisa.dia.gas.jpbc.Element;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AbeOutputStream extends DataOutputStream {

    private AbePublicKey pubKey;

    public AbeOutputStream(OutputStream out, AbePublicKey pubKey) {
        super(out);
        this.pubKey = pubKey;
    }

    // only used for the curve parameters and attributes, no need for fancy encodings
    public void writeString(String string) throws IOException {
        byte[] bytes = string.getBytes(AbeSettings.STRINGS_LOCALE);
        writeInt(bytes.length);
        write(bytes);
    }

    public void writeElement(Element elem) throws IOException {
        writeInt(pubKey.getPairing().getFieldIndex(elem.getField()));
        byte[] bytes = elem.toBytes();
        writeInt(bytes.length);
        write(bytes);
    }

}
