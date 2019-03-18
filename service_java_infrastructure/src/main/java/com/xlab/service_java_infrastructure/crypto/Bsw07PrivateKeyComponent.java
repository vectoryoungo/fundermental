/*
 * module: fundermental
 * file: Bsw07PrivateKeyComponent.java
 * date: 3/14/19 11:21 AM
 * author: VectorJu
 */

package com.xlab.service_java_infrastructure.crypto;

import it.unisa.dia.gas.jpbc.Element;

import java.io.IOException;

public class Bsw07PrivateKeyComponent {
    /* these actually get serialized */
    /**
     * G2
     **/
    public Element hashedAttribute;
    /**
     * G2
     **/
    public Element d;
    /**
     * G2
     **/
    public Element dp;

    public Bsw07PrivateKeyComponent(Element hashedAttribute, Element d, Element dp) {
        this.hashedAttribute = hashedAttribute;
        this.d = d;
        this.dp = dp;
    }


    @Override
    public String toString() {
        return hashedAttribute.toString();
    }

    public static Bsw07PrivateKeyComponent readFromStream(AbeInputStream abeStream) throws IOException {
        Element hashedAttribute = abeStream.readElement();
        Element d = abeStream.readElement();
        Element dp = abeStream.readElement();
        return new Bsw07PrivateKeyComponent(hashedAttribute, d, dp);
    }

    public void writeToStream(AbeOutputStream abeStream) throws IOException {
        abeStream.writeElement(hashedAttribute);
        abeStream.writeElement(d);
        abeStream.writeElement(dp);
    }
}
