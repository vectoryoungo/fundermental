package com.xlab.service_java_infrastructure.http;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.math.BigDecimal;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class GetAndGenerateExcel {

    private static Logger logger = LoggerFactory.getLogger(GetAndGenerateExcel.class);

    public static void main(String[] args) {
        generateExcel();
    }

    public static void generateExcel() {

        //第一步  创建一个webbook 对应一个excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //第二步 在webbook中添加一个sheet,对应excel中的sheet
        HSSFSheet sheet = wb.createSheet("qtum_data");
        //第三步 在sheet中添加表头第0行 注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style =wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); //创建一个居中格式
        HSSFCell cell1 = row.createCell(0);
        cell1.setCellValue("时间戳");
        cell1.setCellStyle(style);
        HSSFCell cell2 = row.createCell(1);
        cell2.setCellValue("交易ID");
        cell2.setCellStyle(style);
        HSSFCell cell3 = row.createCell(2);
        cell3.setCellValue("账户余额");
        cell3.setCellStyle(style);
        HSSFCell cell4 = row.createCell(3);
        cell4.setCellValue("变动");
        cell4.setCellStyle(style);

        List<Transaction> transactionList = getTransactionList();

        for (int i=0;i<transactionList.size();i++) {
            row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(transactionList.get(i).getTimestamp());
            row.createCell(1).setCellValue(transactionList.get(i).getTransactionId());
            HSSFCell hssfCell = row.createCell(2);
            hssfCell.setCellType(HSSFCell.CELL_TYPE_STRING);
            hssfCell.setCellValue(Double.valueOf(transactionList.get(i).getBalance()));
            row.createCell(3).setCellValue(transactionList.get(i).getRange());
        }

        try {
            FileOutputStream fos = new FileOutputStream("qutm.xls");
            wb.write(fos);
            fos.flush();
            fos.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Transaction> getTransactionList() {
        List<Transaction> transactionList = new ArrayList<>();

        String balanceHistory = doGet("https://qtum.info/api/address/Qc6iYCZWn4BauKXGYirRG8pMtgdHMk2dzn/balance-history?limit=65535&offset=131070");
        JSONObject  balanceHistoryJson = (JSONObject) JSON.parse(balanceHistory);
        JSONArray jsonArrayBalance = balanceHistoryJson.getJSONArray("transactions");
        Iterator iterator = jsonArrayBalance.iterator();

        while (iterator.hasNext()) {
            Transaction transaction = new Transaction();
            JSONObject jsonObject = (JSONObject) iterator.next();
            String txid = jsonObject.getString("id");
            String timestamp = jsonObject.getString("timestamp");
            String amount = jsonObject.getString("amount");
            String balance = jsonObject.getString("balance");
            if (new BigDecimal(amount).compareTo(BigDecimal.ZERO) > 0) {
                transaction.setRange("+" + amount);
            }else if (new BigDecimal(amount).compareTo(BigDecimal.ZERO) < 0) {
                transaction.setRange("-" + amount);
            }else {
                transaction.setRange("0");
            }

            transaction.setTransactionId(txid);
            transaction.setBalance(balance);
            transaction.setTimestamp(convertTimeToString(Long.valueOf(timestamp)));
            transactionList.add(transaction);
        }
        return transactionList;
    }

    /**
     * @return
     */
    public static String doGet(String url) {
        try {
            HttpClient client = new DefaultHttpClient();

            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

                String strResult = EntityUtils.toString(response.getEntity());

                return strResult;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * post请求(用于key-value格式的参数)
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, Map params){

        BufferedReader in = null;
        try {
            // 定义HttpClient
            HttpClient client = new DefaultHttpClient();
            // 实例化HTTP方法
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));

            //设置参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));

                //System.out.println(name +"-"+value);
            }
            request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));

            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if(code == 200){	//请求成功
                in = new BufferedReader(new InputStreamReader(response.getEntity()
                        .getContent(),"utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }

                in.close();

                return sb.toString();
            }
            else{	//
                System.out.println("状态码：" + code);
                return null;
            }
        }
        catch(Exception e){
            e.printStackTrace();

            return null;
        }
    }

    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, String params) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params, charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;

        try {

            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            }
            else{
                logger.error("请求返回:"+state+"("+url+")");
            }
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static String convertTimeToString(Long time){
        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochSecond(time),ZoneId.systemDefault()));
    }
}
