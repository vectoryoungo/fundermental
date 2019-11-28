/**
 * @create 2019-08-25 15:45
 * @desc SHA256
 **/
package com.xlab.service_java_infrastructure.bitcoinj.hd;

import org.spongycastle.crypto.digests.SHA256Digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
    public static byte[] sha256(byte[] bytes) {
        return sha256(bytes, 0, bytes.length);
    }

    public static byte[] sha256(byte[] bytes, int offset, int size) {
        SHA256Digest sha256Digest = new SHA256Digest();
        sha256Digest.update(bytes, offset, size);
        byte[] sha256 = new byte[32];
        sha256Digest.doFinal(sha256, 0);
        return sha256;
    }

    public static byte[] doubleSha256(byte[] bytes) {
        return doubleSha256(bytes, 0, bytes.length);
    }

    public static byte[] doubleSha256(byte[] bytes, int offset, int size) {
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            sha256.update(bytes, offset, size);
            return sha256.digest(sha256.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}

