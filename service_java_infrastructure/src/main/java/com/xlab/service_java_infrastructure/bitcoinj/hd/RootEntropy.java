package com.xlab.service_java_infrastructure.bitcoinj.hd;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @Description:创建种子钱包
 * 使用CSPRNG（安全伪随机数生成器）生成随机列（熵）
 **/
public class RootEntropy {

    private byte[]              entropy; //随机数（熵）

    public RootEntropy(){
        entropy = getEntropy(128 );	// 128 bits = 16 * 8 bits
    }

    /**
     * 生成随机数序列
     * @param bits
     * @return
     */
    private byte[] getEntropy(int bits){
        byte[] result = new byte[ bits/8 ];

        SecureRandom random = null;
        try {
            random = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        assert random != null;
        random.nextBytes(result);

        return result;
    }

    /**
     * 将Byte数组转换为十六进制表示
     * @param bytes
     * @return hex string
     */
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    // Getter and no Setter
    public byte[] getEntropy(){
        return entropy;
    }

    String getEntropyStr(){
        return bytesToHex(entropy);
    }

}
