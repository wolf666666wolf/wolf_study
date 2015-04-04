package com.study.javase.security;

import java.security.KeyStore;

public class KeyStoreHandler {

	KeyStore ks;
	private char[] pw;
	
	public KeyStoreHandler(char[] pw){
		if(pw!=null){
			this.pw = new char[pw.length];
			System.arraycopy(pw, 0, this.pw, 0, pw.length);
		}
	}
}
