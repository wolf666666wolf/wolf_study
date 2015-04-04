package com.study.javase.security;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
/**
 * 消息摘要是一种与消息认证码结合使用，以确保消息完整性的技术。消息摘要函数是单向函数
 * @author Administrator
 *
 */
public class DigestTest {

	public static void main(String[] args){
		String contenFileName="testMac";
		String keyFileName = "exportedSecretKey";
		
		sendMac(contenFileName, keyFileName);
		System.out.println(">>>>>>>>>>>>>>>>>>>Send finished");
		receiveMac(contenFileName, keyFileName);
		System.out.println(">>>>>>>>>>>>>>>>>>>Receive finished");
	}
	
	public static void sendMac(String contentFileName, String keyFileName){
		try{
			
			FileOutputStream fos = new FileOutputStream(contentFileName);
			Mac mac = Mac.getInstance("HmacSHA1");
			
			//生成秘密密钥,Mac初始化需要一个秘密密钥
			KeyGenerator kg = KeyGenerator.getInstance("DES");
			SecretKey sk = kg.generateKey();
			mac.init(sk);
			
			//将秘密密钥保存起来
			//String file1 = "";
			FileOutputStream fos_esk = new FileOutputStream(keyFileName);
			ObjectOutputStream oos_esk = new ObjectOutputStream(fos_esk);
			oos_esk.writeObject(sk);
			
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			String data = "This have I though good to deliver thee, by being ignorant of what greatness is promised thee.";
			byte[] buf = data.getBytes();
			mac.update(buf);
			oos.writeObject(data);
			oos.writeObject(mac.doFinal());
			
			oos.close();
			oos_esk.close();
			fos_esk.close();
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public static void receiveMac(String contentFileName, String keyFileName){
		try{
			FileInputStream fis = new FileInputStream(contentFileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o = ois.readObject();//读原文
			if( !(o instanceof String)){
				System.out.println("Unexpected data in file");
				System.exit(-1);
			}
			String data = (String)o;
			System.out.println("Got message:" + data);
			o = ois.readObject(); //读摘要
			if( !(o instanceof byte[])){
				System.out.println("Unexpected data in file");
			}
			byte[] origDigest = (byte[])o;
			Mac mac = Mac.getInstance("HmacSHA1");
			
			//从密钥文件中得到秘密密钥，初始化Mac
			FileInputStream fis_esk = new FileInputStream(keyFileName);
			ObjectInputStream ois_esk = new ObjectInputStream(fis_esk);
			SecretKey sk = (SecretKey)ois_esk.readObject();
		    mac.init(sk);
		    mac.update(data.getBytes());
		    if(new String(mac.doFinal()).equals(new String(origDigest))){//两次摘要比较
		    	System.out.println("Message is valid");
		    	//System.out.println("DIGEST:"+new String(origDigest));
		    }else{
		    	System.out.println("Message was corrupted");
		    }
			
		    ois_esk.close();
		    fis_esk.close();
		    ois.close();
		    fis.close();
		    
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
