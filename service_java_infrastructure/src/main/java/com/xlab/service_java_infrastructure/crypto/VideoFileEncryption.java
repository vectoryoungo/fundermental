/*
 * module: fundermental
 * file: VideoFileEncryption.java
 * date: 2/12/19 3:09 PM
 * author: VectorJu
 */

/**
 * @create 2019-02-12 15:09
 * @desc video encryption
 **/
package com.xlab.service_java_infrastructure.crypto;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

public class VideoFileEncryption {

    public static void main(String[] args) {
        //encryptVideo(null);
        encrypt(null);
        //decrypt(null);
    }

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
            File file = new File("/Users/juhongtao/Downloads/1547823353303150duplicate.mp4");
            if(file.exists()&&file.isFile()){

                long size = file.length();

                buffer=new RandomAccessFile("/Users/juhongtao/Downloads/1547823353303150duplicate.mp4","rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 10);
                int sum=0;
                int n;
                long t1=System.currentTimeMillis();
                for(int i=0;i<10;i++){
                    byte src=   buffer.get(i);
                    System.out.println("before :"+src);
                    src = (byte)(src^XOR);
                    System.out.println("after :"+src);
                    buffer.put(i,src);//修改Buffer中映射的字节的值

                }
                buffer.force();
                buffer.clear();

                long t=System.currentTimeMillis()-t1;
                System.out.println("sum:"+sum+"  time:"+t);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void encryptNonVideoFile(int cipherMode,String key,File inputFile,File outputFile) {

        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密方法，只加密小文件比如文本文件等，大文件视频文件采用上面encryptVideo()方法
     *
     */
    public static void encrypt(String fileUrl){

        String tempFilePath = null;

        if (fileUrl == null) {
            tempFilePath = "/Users/juhongtao/ciphertext.txt";
        }else {
            tempFilePath = fileUrl;
        }

        try {

            KeyGenerator kg = KeyGenerator.getInstance("DES");
            kg.init(new SecureRandom());
            SecretKey key = kg.generateKey();
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            Class spec = Class.forName("javax.crypto.spec.DESKeySpec");
            DESKeySpec ks = (DESKeySpec) skf.getKeySpec(key, spec);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/juhongtao/keyfile"));
            oos.writeObject(ks.getKey());

            Cipher c = Cipher.getInstance("DES/CFB8/NoPadding");
            c.init(Cipher.ENCRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(new FileOutputStream(tempFilePath), c);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(cos,"utf-8"));
            pw.println("this is secret content");
            pw.close();
            oos.writeObject(c.getIV());
            oos.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解密方法，只解密加密的文本文件。
     *
     */
    public static void decrypt(String fileUrl){

        String tempFilePath = null;

        if (fileUrl == null) {
            tempFilePath = "/Users/juhongtao/ciphertext.txt";
        }else {
            tempFilePath = fileUrl;
        }

        try {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream("/Users/juhongtao/keyfile"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            DESKeySpec ks = null;
            try {
                ks = new DESKeySpec((byte[]) ois.readObject());
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            SecretKeyFactory skf = null;
            try {
                skf = SecretKeyFactory.getInstance("DES");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            SecretKey key = null;
            try {
                key = skf.generateSecret(ks);
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }

            Cipher c = null;
            try {
                c = Cipher.getInstance("DES/CFB8/NoPadding");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            }
            try {
                c.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec((byte[]) ois.readObject()));
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            CipherInputStream cis = null;
            try {
                cis = new CipherInputStream(new FileInputStream(tempFilePath), c);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(cis,"utf-8"));
            System.out.println(br.readLine());
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}

