/*
 * module: fundermental
 * file: Bsw07Util.java
 * date: 3/14/19 11:26 AM
 * author: VectorJu
 * copyright: (c) 2018 www.onechain001.com Inc. All rights reserved.
 * 注意：本内容仅限于上海旺链信息科技有限公司内部传阅，禁止外泄以及用于其他的商业目的，否则将依法追责。
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
