/*
 * module: fundermental
 * file: DownloadWithProgressShow.java
 * date: 4/22/19 11:13 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-22 11:13
 * @desc test  download show progress
 **/
package com.xlab.service_java_infrastructure.downloadprocess;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadWithProgressShow {


    public static void dowanload(String url, String path)
            throws IOException {
        System.out.println("download...");
        InputStream inputStream = null;
        RandomAccessFile randomAccessFile = null;
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(10 * 1000);
            File file = new File(path);
            //文件夹是否存在
            if (!file.getParentFile().exists())
                file.getParentFile().mkdir();
            if (file.exists())
                file.delete();
            file.createNewFile();

            int responseCode = urlConnection.getResponseCode();
            if (responseCode >= 200 && responseCode < 300) {
                inputStream = urlConnection.getInputStream();
                int len = 0;
                byte[] data = new byte[4096];
                //用于保存当前进度（具体进度）
                int progres = 0;
                //get file length
                int maxProgres = urlConnection.getContentLength();
                randomAccessFile = new RandomAccessFile(file, "rwd");
                //set file size
                randomAccessFile.setLength(maxProgres);
                //将文件大小分成100分，每一分的大小为unit
                int unit = maxProgres / 100;
                //用于保存当前进度(1~100%)
                int unitProgress = 0;
                while (-1 != (len = inputStream.read(data))) {
                    randomAccessFile.write(data, 0, len);
                    progres += len;//保存当前具体进度
                    int temp = progres / unit; //计算当前百分比进度
                    if (temp >= 1 && temp > unitProgress) {//如果下载过程出现百分比变化
                        unitProgress = temp;//保存当前百分比
                        System.out.println("downloading..." + unitProgress + "%");
                    }
                }
                inputStream.close();
                System.out.println("finished...");
            } else {
                System.out.println("server error ...");
            }
        } finally {
            if (null != inputStream) {
                inputStream.close();
            }
            if (null != randomAccessFile) {
                randomAccessFile.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/oyo03889/image.jpg";
        String url="https://raw.githubusercontent.com/smuyyh/ImageSelector/master/screenshot/screen_1.png";
        dowanload(url, path);
    }
}

