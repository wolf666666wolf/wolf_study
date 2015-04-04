package com.study.open.httpclient.examples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class Test1 {

	public static void main(String[] args) throws ClientProtocolException, IOException{
		String url = "http://www.iteye.com/login";
		String userName="liu666666";
		String pwd = "025c0710";
		DefaultHttpClient httpclient = new DefaultHttpClient();
//		HttpGet httpget = new HttpGet(url);
//        HttpResponse response = httpclient.execute(httpget);
//        HttpEntity entity = response.getEntity();
//        EntityUtils.consume(entity);
        
        
		HttpPost httppost = new HttpPost(url);
        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add(new BasicNameValuePair("name", userName));
        nvps.add(new BasicNameValuePair("password", pwd));

        httppost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Login form get: " + response.getStatusLine());        
        if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
        	    || statusCode == HttpStatus.SC_MOVED_TEMPORARILY
        	    || statusCode == HttpStatus.SC_SEE_OTHER
        	    || statusCode == HttpStatus.SC_TEMPORARY_REDIRECT) {
	        String newUrl = response.getLastHeader("Location").getValue();
	        System.out.println("从新定向的页面为：" + newUrl);
	        
        }else if (statusCode == HttpStatus.SC_OK) {

        	   Header headers[] = response.getAllHeaders();

        	   System.out.println("--==headers information==--");
        	   for (Header header : headers) {
        		   System.out.println(header.getName() + ": " + header.getValue());
        	   }
        }

        System.out.println("--==cookies information==--");
        List<Cookie> cookies2 = ((AbstractHttpClient) httpclient).getCookieStore().getCookies();
        if (cookies2.isEmpty()) {
        	System.out.println("None");
        } else {
        	for (int i = 0; i < cookies2.size(); i++) {
        		System.out.println("- " + cookies2.get(i).toString());
        	}
        }
        // 打开浏览器
        HttpEntity entity2 = response.getEntity();
        // 显示内容
        if (entity2 != null) {
         String content = EntityUtils.toString(entity2);
         System.out.println(content);
         int firstIndex = content.lastIndexOf('=');
         int lastIndex = content.lastIndexOf('/');
         String suffix = content
           .substring(firstIndex + 1, lastIndex + 1);

         System.out.println("suffix:" + suffix);
         String newUrl = "http://bbs.xjtu.edu.cn" + suffix;

         String newContent = content.substring(0, firstIndex + 1)
           + newUrl + content.substring(lastIndex + 1);

         System.out.println("newURL:\n" + newContent);
         //runBroswer(newUrl);
        }

        

		
		
	}
}
