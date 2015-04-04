package com.study.javase.io;

import java.io.File;
import java.io.IOException;

public class DirSize {

	public static long getTotal(String pathName) throws IOException{
		long total = 0;
		File file = new File(pathName);
		if(file.isFile()){
			return file.length();
		}else{
			String[] childFilePathName = file.list();
			for(int i=0; i< childFilePathName.length; i++){
				total = total + getTotal(pathName + "/" + childFilePathName[i]);
			}
		}
		return total;
	}
	
	public static void main(String[] args) throws IOException{
		String pathName = "F:/TDDOWNLOAD";
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>total:" + getTotal(pathName));
	}
}
