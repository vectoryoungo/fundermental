package com.xlab.service_java_infrastructure.bitcoinj.hd;

import org.spongycastle.util.Strings;

import java.math.BigInteger;

public class Base64 {
    public static String decode(String input) {
        return Strings.fromByteArray(org.spongycastle.util.encoders.Base64.decode(input));
    }

    public static String encode(BigInteger input) {
        return String.format("%064x", input);
    }

    public static String encode(byte[] input) {
        return Strings.fromByteArray(org.spongycastle.util.encoders.Base64.encode(input));
    }
}
