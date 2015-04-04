package com.study.javase.security;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SignatureTest {

	public static void send(String fileName){
		String data = "This is an example of Signature";
		try{
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//KeyStoreHandler
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
