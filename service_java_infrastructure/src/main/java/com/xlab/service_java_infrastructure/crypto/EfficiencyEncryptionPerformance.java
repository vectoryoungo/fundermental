/*
 * module: fundermental
 * file: EfficiencyEncryptionPerformance.java
 * date: 2/12/19 11:23 AM
 * author: VectorJu
 */

/**
 * @create 2019-02-12 11:23
 * @desc java encryption
 **/
package com.xlab.service_java_infrastructure.crypto;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.PBEParameterSpec;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class EfficiencyEncryptionPerformance {

    public static void main(String[] args) {
        int c = 0, BUF_SIZE = 8192;
        byte[] b = new byte[BUF_SIZE];
        FileInputStream fis;
        DataInputStream dis;
        FileOutputStream fos;
        DataOutputStream dos;
        CipherOutputStream cos;


        try {
            // Create PBE parameter set
            //pbeParamSpec = new PBEParameterSpec(salt, iterationCount);

            // Create PBE Cipher
            //Cipher pbeCipher = Cipher.getInstance(algorithm);

            // get key
            //key = generateKeyFromPassword(password);

            // Initialize PBE Cipher with key and parameters
            //pbeCipher.init(Cipher.ENCRYPT_MODE, key, pbeParamSpec);

            //fis = new FileInputStream(inFile);
            //dis = new DataInputStream(fis);
            //fos = new FileOutputStream(outFile);
            //dos = new DataOutputStream(fos);
            //cos = new CipherOutputStream(fos, pbeCipher);


           /* while ((c = dis.read(b)) > 0) {
                cos.write(b);
                //dos.write(b);
            }

            fis.close();
            dis.close();
            //dos.close();
            cos.close();
*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

