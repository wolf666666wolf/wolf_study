/*
 * ConnectionPost.java
 * Copyright 2002-2013 BULL SAS, Inc. All Rights Reserved.
 * This software is the proprietary information of BULL SAS, Inc.
 * Use is subject to license terms.
 */
package com.study.open.httpclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentProducer;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ConnectionPost {
 static String TEST_URL = "";
  private static void urlConnectionPost() {
    StringBuilder responseBuilder = null;
    BufferedReader reader = null;
    OutputStreamWriter wr = null;
   

    URL url;
    try {
      url = new URL(TEST_URL);
      URLConnection conn = url.openConnection();
      conn.setDoOutput(true);
      conn.setConnectTimeout(1000 * 5);
      wr = new OutputStreamWriter(conn.getOutputStream());
      wr.write("");
      wr.flush();

      // Get the response
      reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      responseBuilder = new StringBuilder();
      String line = null;
      while ((line = reader.readLine()) != null) {
        responseBuilder.append(line + "\n");
      }
      wr.close();
      reader.close();

      System.out.println(responseBuilder.toString());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
  
  private static void httpClientPost() {
    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost(TEST_URL);

    try {
        ContentProducer cp = new ContentProducer() {
            public void writeTo(OutputStream outstream) throws IOException {
                Writer writer = new OutputStreamWriter(outstream, "UTF-8");
                writer.write("");
                writer.flush();
            }
        };

        post.setEntity(new EntityTemplate(cp));
        HttpResponse response = client.execute(post);
   
        System.out.println(EntityUtils.toString(response.getEntity()));
    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}  
  
  private static void testpost(){
//
//      
//      // 核心应用类  
//      HttpClient httpClient = new DefaultHttpClient();  
// 
//       // HTTP请求  
////       HttpUriRequest request =   new HttpGet("http://localhost/index.html");  
//      HttpUriRequest request =   new HttpPost("http://localhost/index.html"); 
//      MultipartEntity entity = new MultipartEntity();  
//      entity.addPart("param1", new StringBody("中国", Charset.forName("UTF-8")));  
//      entity.addPart("param2", new StringBody("value2", Charset.forName("UTF-8")));  
//      entity.addPart("param3", new FileBody(new File("C:\\1.txt")));  
//         
//      HttpPost request = new HttpPost(“http://localhost/index.html”);  
//      request.setEntity(entity); 
//       // 打印请求信息  
////       System.out.println(request.getRequestLine());  
//       try {  
//           // 发送请求，返回响应  
//           HttpResponse response = httpClient.execute(request);  
// 
//           // 打印响应信息  
//           System.out.println(response.getStatusLine());  
//       } catch (ClientProtocolException e) {  
//           // 协议错误  
//           e.printStackTrace();  
//       } catch (IOException e) {  
//           // 网络异常  
//           e.printStackTrace();  
//       }  
//   
  }
  
  public boolean postFile(String url, File f) {
    if (url == null || f == null) {
      System.out.println("URL或者文件为NULL");
      return false;
    }
    HttpClient client = new DefaultHttpClient();
    HttpPost httpPost = new HttpPost(url);
    HttpResponse response = null;
    InputStream in  = null;
    
    try {
      long len = this.getLength(in);
      InputStreamEntity entity = new InputStreamEntity(in, len);
      httpPost.setEntity(entity);
      response = client.execute(httpPost);
    } catch (Exception e) {
      System.out.println(e.toString());
    } finally {
    }

    if (response != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
      return true;
    } else {
      System.out.println(response.getStatusLine().getStatusCode());
    }
    return false;
  }  
  
  private long getLength(InputStream in) throws IOException{
//    byte b[] = new byte[1024];  
    int len = 0;  
    int temp=0;          //所有读取的内容都使用temp接收  
    while((temp=in.read())!=-1){    //当没有读取完时，继续读取  
//        b[len]=(byte)temp;  
        len++;  
    } 
    return len;
  }
}
