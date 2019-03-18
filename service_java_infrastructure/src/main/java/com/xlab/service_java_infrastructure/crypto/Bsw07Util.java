/*
 * module: fundermental
 * file: Bsw07Util.java
 * date: 3/14/19 11:26 AM
 * author: VectorJu
 */

package com.xlab.service_java_infrastructure.crypto;

import it.unisa.dia.gas.jpbc.Element;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Bsw07Util {
    public static Element elementG2FromString(String s, AbePublicKey publicKey) {
        try {
            MessageDigest sha1 = MessageDigest.getInstance(AbeSettings.ELEMENT_HASHING_ALGORITHM);
            byte[] digest = sha1.digest(s.getBytes());
            return publicKey.getPairing().getG2().newElementFromHash(digest, 0, digest.length);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing Alogrithm not available: " + AbeSettings.ELEMENT_HASHING_ALGORITHM, e);
        }
    }
}
