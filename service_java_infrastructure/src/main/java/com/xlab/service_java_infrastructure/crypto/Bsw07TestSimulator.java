/*
 * module: fundermental
 * file: Bsw07TestSimulator.java
 * date: 3/15/19 4:27 PM
 * author: VectorJu
 */

/**
 * @create 2019-03-14 10:27
 * @desc simulator
 **/
package com.xlab.service_java_infrastructure.crypto;


import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * ＣＰ－ＡＢＥ算法
 * ＣＰ－ＡＢＥ算法的４个主要步骤：
 * 1.Ｓｅｔｕｐ．生成主密钥 ＭＫ 和公开参数 ＰＫ．
 * 2.ＣＴ＝Ｅｎｃｒｙｐｔ（ＰＫ，Ｍ，Ｔ）．使用 ＰＫ、访问结构Ｔ 和加密数据明文Ｍ，加密后的密文为 ＣＴ．
 * 3.ＳＫ＝ＫｅｙＧｅｎ（ＭＫ，Ａ）．使用 ＭＫ 和用户属性集Ａ 生成用户的私钥ＳＫ．
 * 4.Ｍ＝Ｄｅｃｒｙｐｔ（ＣＴ，ＳＫ）．使用私钥ＳＫ 解密密文 ＣＴ 得到明文 Ｍ．
 *
 * CP-ABE算法
 * CP-ABE算法4个主要步骤：
 * 1.Setup.生成主密钥MK和公开参数PK
 * 2.CT＝Encrypt(PK,M,T).使用PK、访问结构T和加密数据明文Ｍ,加密后的密文为CT.
 * 3.SK＝KenGen(MK,A).使用MK和用户属性集A生成用户的私钥SK.
 * 4.M＝Decrypt(CT,SK).使用私钥SK解密密文CT得到明文M.
 */

public class Bsw07TestSimulator {

    static {
        SecureRandom random = new SecureRandom();
    }

    // so we dont need to check for exceptions every time we want to decrypt
    private byte[] decrypt(AbePrivateKey privateKey, AbeEncrypted encryptedData) {
        try {
            return Cpabe.decrypt(privateKey, encryptedData);
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] forceDecrypt(AbeSecretMasterKey secretKey, AbeEncrypted encryptedData) {
        try {
            return CpabeExperimental.forceDecrypt(secretKey, encryptedData);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Bsw07TestSimulator bsw07TestSimulator = new Bsw07TestSimulator();
        try {
            bsw07TestSimulator.restoreFromParam();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAttributesTest() throws Exception {
        AbeSecretMasterKey smKey = Cpabe.setup();
        System.out.println("MasterKey beta is " + smKey.beta);
        System.out.println("MasterKey g_alpha is " + smKey.g_alpha);
        System.out.println("MasterKey's public key is " + smKey.getPublicKey());
        AbePublicKey pubKey = smKey.getPublicKey();
        System.out.println("AbePublicLKey is " + pubKey);

//        byte[] data = TUtil.getRandomData();
        byte[] data = new String("民主制度").getBytes();

        String policy1 = "att1 or att3";
        String policy2 = "att3 or att4 >= 5";

        AbeEncrypted policy1EncryptedTest1 = Cpabe.encrypt(pubKey, policy1, data);
       /* AbeEncrypted policy2EncryptedTest1 = Cpabe.encrypt(pubKey, policy2, data);

        AbeEncrypted policy1EncryptedTest2 = Cpabe.encrypt(pubKey, policy1, data);
        AbeEncrypted policy2EncryptedTest2 = Cpabe.encrypt(pubKey, policy2, data);

        AbeEncrypted policy1EncryptedTest3 = Cpabe.encrypt(pubKey, policy1, data);
        AbeEncrypted policy2EncryptedTest3 = Cpabe.encrypt(pubKey, policy2, data);

        AbeEncrypted policy1EncryptedTest4 = Cpabe.encrypt(pubKey, policy1, data);
        AbeEncrypted policy2EncryptedTest4 = Cpabe.encrypt(pubKey, policy2, data);

        AbeEncrypted policy1EncryptedTest5 = Cpabe.encrypt(pubKey, policy1, data);
        AbeEncrypted policy2EncryptedTest5 = Cpabe.encrypt(pubKey, policy2, data);*/

        //============================================================================

        System.out.println("AbeEncrypted is " + policy1EncryptedTest1);


        /*String att1att2Attribute = "att1";
        String att1Attribute = "att1";

        AbePrivateKey att1att2Key = Cpabe.keygen(smKey, att1att2Attribute);
        AbePrivateKey att1Key = Cpabe.keygen(smKey, att1Attribute);
        byte[] decryptByte = decrypt(att1att2Key, policy1EncryptedTest1);

        if (Arrays.equals(data,decryptByte)) {
            System.out.println("equals");
            String resultString = new String(decryptByte,"utf-8");
            System.out.println(" resultString is " + resultString);
        }else {
            System.out.println("not equals");
        }*/

        //============================================================================

        //assertTrue(Arrays.equals(data, decrypt(att1att2Key, policy1EncryptedTest1)));
        //assertFalse(Arrays.equals(data, decrypt(att1att2Key, policy2EncryptedTest1)));

        //assertFalse(Arrays.equals(data, decrypt(att1Key, policy1EncryptedTest2)));
        //assertFalse(Arrays.equals(data, decrypt(att1Key, policy2EncryptedTest2)));

        /*AbePrivateKey att1att2att3Key = CpabeExperimental.keyWithAddedAttributes(att1att2Key, smKey, "att3");
        AbePrivateKey att1att3Key = CpabeExperimental.keyWithAddedAttributes(att1Key, smKey, "att3");
        AbePrivateKey att1att4Key = CpabeExperimental.keyWithAddedAttributes(att1Key, smKey, "att4 = 42");
*/


        //assertTrue(Arrays.equals(data, decrypt(att1att2att3Key, policy1EncryptedTest3)));
        //assertTrue(Arrays.equals(data, decrypt(att1att2att3Key, policy2EncryptedTest3)));

        //assertTrue(Arrays.equals(data, decrypt(att1att3Key, policy1EncryptedTest4)));
        //assertTrue(Arrays.equals(data, decrypt(att1att3Key, policy2EncryptedTest4)));

        //assertFalse(Arrays.equals(data, decrypt(att1att4Key, policy1EncryptedTest5)));
        //assertTrue(Arrays.equals(data, decrypt(att1att4Key, policy2EncryptedTest5)));
    }

    public void restoreFromParam() {

        File inputFile = new File("/Users/juhongtao/abecrypttestfile.txt");
        File encryptedFile = new File("a.enc");
        File decryptedFile = new File("adec.txt");
        File publicKey = new File("a.pkey");
        File secretKey = new File("a.mkey");
        File privateKey = new File("user.private");

        try {
            BufferedInputStream bin = new BufferedInputStream( new FileInputStream(inputFile));
            int p = (bin.read() << 8) + bin.read();
            String code = null;
            switch (p) {
                case 0xefbb:
                    code = "UTF-8";
                    break;
                case 0xfffe:
                    code = "Unicode";
                    break;
                case 0xfeff:
                    code = "UTF-16BE";
                    break;
                case 0x5c75:
                    code = "ANSI|ASCII" ;
                    break ;
                default:
                    code = "GBK";
            }
            System.out.println("code is " + code);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        //inputFile.delete();
        encryptedFile.delete();
        decryptedFile.delete();
        publicKey.delete();
        secretKey.delete();
        privateKey.delete();

        try {
            Cpabe.setup(publicKey, secretKey);
            Cpabe.encrypt(publicKey, "a and b", inputFile, encryptedFile);
            Cpabe.keygen(privateKey, secretKey, "a b c");
            Cpabe.decrypt(privateKey, encryptedFile, decryptedFile);
        }catch (IOException e) {
            e.printStackTrace();
        }catch (AbeEncryptionException e) {
            e.printStackTrace();
        }catch (AbeDecryptionException e){
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

