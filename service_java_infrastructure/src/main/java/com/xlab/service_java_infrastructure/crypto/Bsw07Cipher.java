/*
 * module: fundermental
 * file: Bsw07Cipher.java
 * date: 3/14/19 11:22 AM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
 */

package com.xlab.service_java_infrastructure.crypto;

import it.unisa.dia.gas.jpbc.Element;

import java.io.IOException;

public class Bsw07Cipher {
    /*
     * A ciphertext. Note that this library only handles encrypting a single group element, so if you want to encrypt something
     * bigger, you will have to use that group element as a symmetric key for hybrid encryption (which you do yourself).
     */
    public Bsw07PolicyAbstractNode policyTree;
    /**
     * GT
     **/
    private Element cs;
    /**
     * G1
     **/
    private Element c;

    public Bsw07Cipher(Bsw07PolicyAbstractNode policy, Element cs, Element c) {
        this.policyTree = policy;
        this.cs = cs;
        this.c = c;
    }

    public static Bsw07Cipher readFromStream(AbeInputStream stream) throws IOException {
        Element cs = stream.readElement();
        Element c = stream.readElement();
        Bsw07PolicyAbstractNode policyTree = Bsw07PolicyAbstractNode.readFromStream(stream);
        return new Bsw07Cipher(policyTree, cs, c);
    }

    public Element getCs() {
        return cs;
    }

    public Element getC() {
        return c;
    }

    public void writeToStream(AbeOutputStream stream) throws IOException {
        stream.writeElement(cs);
        stream.writeElement(c);
        policyTree.writeToStream(stream);
    }
}
