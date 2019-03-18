/*
 * module: fundermental
 * file: AESUtils.java
 * date: 3/13/19 4:02 PM
 * author: VectorJu
 */

/*
 * module: fundermental
 * file: AESUtils.java
 * date: 2/19/19 11:08 AM
 * author: VectorJu
 */

/**
 * @create 2019-02-19 11:08
 * @desc AESUtils
 **/
package com.xlab.service_java_infrastructure.crypto;

import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtils {


    private static final String encodeRules = "vonechain";


    /**
     * 视频文件加密方法只是简单地异或运算
     * @param fileUrl
     */
    public static void encryptVideo(String fileUrl) {

        String tempFilePath = null;

        if (fileUrl == null) {
            tempFilePath = "/Users/juhongtao/Downloads/1547823353303150duplicate.mp4";
        }else {
            tempFilePath = fileUrl;
        }

        byte XOR = 0X12;
        MappedByteBuffer buffer=null;
        try {
            File file = new File(tempFilePath);
            if(file.exists()&&file.isFile()){

                buffer=new RandomAccessFile(tempFilePath,"rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 10);

                for(int i=0;i<10;i++){
                    byte src=buffer.get(i);
                    src = (byte)(src^XOR);
                    buffer.put(i,src);//修改Buffer中映射的字节的值

                }
                buffer.force();
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * AES加密字符串
     * 1.构造密钥生成器
     * 2.根据ecnodeRules规则初始化密钥生成器
     * 3.产生密钥
     * 4.创建和初始化密码器
     * 5.内容加密
     * 6.返回字符串
     */
    public static String AESEncode(String content) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeRules.getBytes());
            keygen.init(128, random);
            //3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byte_encode = content.getBytes("utf-8");
            //9.根据密码器的初始化方式--加密：将数据加密
            byte[] byte_AES = cipher.doFinal(byte_encode);
            //10.将加密后的数据转换为字符串
            //这里用Base64Encoder中会找不到包
            //解决办法：
            //在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
            String AES_encode = new String(new BASE64Encoder().encode(byte_AES));
            //11.将字符串返回
            return AES_encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //如果有错就返加nulll
        return null;
    }



    /**
     * AES加密
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     * @throws Exception
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(encryptKey.getBytes()));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }

    /**
     * AES解密加密过的字符串
     * 解密过程：
     * 1.同加密1-4步
     * 2.将加密后的字符串反纺成byte[]数组
     * 3.将加密内容解密
     */
    public static String AESDecode(String content) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeRules.getBytes());
            keygen.init(128, random);
            //3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            //8.将加密并编码后的内容解码成字节数组
            byte[] byte_content = new BASE64Decoder().decodeBuffer(content);
            /*
             * 解密
             */
            byte[] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode, "utf-8");
            return AES_decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        //如果有错就返加nulll
        return null;
    }


    /**
     * AES解密
     * @param encryptBytes 待解密的byte[]
     * @param decryptKey 解密密钥
     * @return 解密后的String
     * @throws Exception
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(decryptKey.getBytes()));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes);
    }

    /**
     * base 64 加密
     * @param bytes 待编码的byte[]
     * @return 编码后的base 64 code
     */
    public static String base64Encode(byte[] bytes){
        return new BASE64Encoder().encode(bytes);
    }

    /**
     * base 64 解密
     * @param base64Code 待解码的base 64 code
     * @return 解码后的byte[]
     * @throws Exception
     */
    public static byte[] base64Decode(String base64Code) throws Exception{
        return StringUtils.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }

    /**
     * 将base 64 code AES解密
     * @param encryptStr 待解密的base 64 code
     * @param decryptKey 解密密钥
     * @return 解密后的string
     * @throws Exception
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }

    /**
     * AES加密为base 64 code
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * 对文件进行AES加密
     * @param sourceFile
     * @param encrypfile
     * @param sKey
     * @return
     */
    public static File encryptFile(File sourceFile, File encrypfile, String sKey) {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(sourceFile);

            outputStream = new FileOutputStream(encrypfile);
            Cipher cipher = initAESCipher(sKey, Cipher.ENCRYPT_MODE);
            // 以加密流写入文件
            CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
            byte[] cache = new byte[1024];
            int nRead = 0;
            while ((nRead = cipherInputStream.read(cache)) != -1) {
                outputStream.write(cache, 0, nRead);
                outputStream.flush();
            }
            cipherInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
        }
        return encrypfile;
    }

    /**
     *  AES方式解密文件
     * @param sourceFile 要解密的文件路径
     * @param decryptFile 解密后的文件路径
     * @param sKey
     * @return
     */
    public static File decryptFile(File sourceFile, File decryptFile, String sKey) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            Cipher cipher = initAESCipher(sKey, Cipher.DECRYPT_MODE);
            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(decryptFile);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = inputStream.read(buffer)) >= 0) {
                cipherOutputStream.write(buffer, 0, r);
            }
            cipherOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace(); // To change body of catch statement use
                // File | Settings | File Templates.
            }
        }
        return decryptFile;
    }

    /**
     * 初始化 AES Cipher
     * @param sKey
     * @param cipherMode
     * @return
     */
    public static Cipher initAESCipher(String sKey, int cipherMode) {
        // 创建Key gen
        KeyGenerator keyGenerator = null;
        Cipher cipher = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(sKey.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] codeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(codeFormat, "AES");
            cipher = Cipher.getInstance("AES");
            // 初始化
            cipher.init(cipherMode, key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        } catch (NoSuchPaddingException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        } catch (InvalidKeyException e) {
            e.printStackTrace(); // To change body of catch statement use File |
            // Settings | File Templates.
        }
        return cipher;
    }

    public static void main(String[] args) {
        /*String[] keys = {"vonechainsuperkey", "rootsuperkey"};
        System.out.println("key | AESEncode | AESDecode");
        for (String key : keys) {
            System.out.print("key:"+key + " | ");
            String encryptString = AESEncode(key);
            System.out.print(encryptString + " | ");
            String decryptString = AESDecode(encryptString);
            System.out.println(decryptString);
        }*/
        //encryptVideo(null);
        String encode = AESEncode("this is test AES encode content ");
        System.out.println(" encode " + encode);
        String decode = AESDecode(encode);
        System.out.println(" after decode : " + decode);
    }
}

